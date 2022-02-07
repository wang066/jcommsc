package com.example.springboot_mq.rocketmq;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@ExtRocketMQTemplateConfiguration
public class ExtRocketMQTemplate extends RocketMQTemplate {
    @Autowired
    RocketMQTemplate rocketMQTemplate;

    public SendResult send(String topic, String tag, Object message) {
        return rocketMQTemplate.syncSend(RocketMQAdUtils.destination(topic, tag), JSON.toJSONString(message));
    }


    //事务消息
    @Component
    public static class RocketMQTransactionTemplate {
        @Autowired
        RocketMQTemplate rocketMQTemplate;
        @Autowired
        LocalTransactionLogService localTransactionLogService;
        @Autowired
        TransactionTemplate transactionTemplate;

        public void send(String topic, String tag, Object payload, Runnable runnable) {
            org.springframework.messaging.Message<String> message = MessageBuilder.withPayload(JSON.toJSONString(payload)).build();
            rocketMQTemplate.sendMessageInTransaction(RocketMQAdUtils.destination(topic, tag), message,
                    new TransactionListener() {
                        @Override
                        public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                                @Override
                                protected void doInTransactionWithoutResult(TransactionStatus status) {
                                    localTransactionLogService.save(message.getTransactionId());
                                    //业务逻辑
                                    runnable.run();
                                }
                            });

                            return LocalTransactionState.COMMIT_MESSAGE;

                        }

                        @Override
                        public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                            if (localTransactionLogService.find(messageExt.getTransactionId()) == null) {
                                return LocalTransactionState.ROLLBACK_MESSAGE;
                            } else {
                                return LocalTransactionState.COMMIT_MESSAGE;
                            }
                        }
                    });
        }

        @Getter
        @Setter
        public static class LocalTransactionLog {
            private long id;
            private String transactionId;
        }

        @Component
        public static class LocalTransactionLogService {

            public void save(String transactionId) {
            }

            public LocalTransactionLog find(String transactionId) {
                return null;
            }


            public void clear() {
                //清除老数据
            }
        }
    }

    @Getter
    @Setter
    public static class RocketMQDelayMsg implements MessagePostProcessor {

        private long id;
        private String topic;
        private String tag;
        private Date triggerTime;
        private String message;

        public boolean check() {
            return true;
        }

        @Override
        public org.springframework.messaging.Message<?> postProcessMessage(org.springframework.messaging.Message<?> message) {
            check();
            return message;
        }

        public Message toMessage() {
            return new Message();
        }
    }


    private static final String delay_topic = "delay_topic";

    //延迟消息
    @Component
    public static class RocketMQDelayMsgTemplate {

        private int DEFAULT_DELAY_PRECISION = 2000;

        @Autowired
        RocketMQTemplate rocketMQTemplate;

        public SendResult send(String topic, String tag, Object payload, Date triggerTime) {
            String delayTopic = RocketMQAdUtils.destination("DelayTopic");
            long diff = (triggerTime.getTime() - System.currentTimeMillis());
            for (RocketMQAdUtils.DelayTimeLevel value : RocketMQAdUtils.DelayTimeLevel.values()) {
                if (Math.abs(diff) < DEFAULT_DELAY_PRECISION) {
                    org.springframework.messaging.Message<?> message = MessageBuilder.withPayload(payload).build();
                    return rocketMQTemplate.syncSend(RocketMQAdUtils.destination(topic, tag), message, 0, value.getLevel());
                }
            }
            RocketMQDelayMsg rocketMQDelayMsg = new RocketMQDelayMsg();
            rocketMQDelayMsg.setId(11L);
            rocketMQDelayMsg.setTopic(topic);
            rocketMQDelayMsg.setTag(tag);
            rocketMQDelayMsg.setMessage(JSON.toJSONString(payload));

            //set 需要发送的topic,tag
            return rocketMQTemplate.syncSend(delayTopic, rocketMQDelayMsg);
        }
    }

    @Slf4j
    @Service
    @RocketMQMessageListener(topic = delay_topic, consumerGroup = "default", consumeThreadMax = 16)
    public class DelayTopicConsumer implements RocketMQListener<RocketMQDelayMsg> {
        @Autowired
        DelayMsgService delayMsgService;

        public void onMessage(RocketMQDelayMsg message) {
            log.info("received message: {}", message);
            DelayMsg msg = new DelayMsg();
            msg.setTopic(message.getTopic());
            msg.setTag(message.getTag());
            msg.setTriggerTime(message.getTriggerTime());
            msg.setStatus(0);
            msg.setBody(message.getMessage());

            delayMsgService.save(msg);
        }
    }

    @Getter
    @Setter
    public static class DelayMsg {

        private long id;
        private String topic;
        private String tag;

        private Date triggerTime;
        private int status;
        private String body;

    }

    @Service
    public static class DelayMsgService {

        public void save(DelayMsg msg) {
        }

        //limit 1000 order by create time
        public List<DelayMsg> find(Date dateStart, int status, int limit) {
            return null;
        }
    }

    @Component
    public static class DelayMsgTask {
        @Autowired
        ExtRocketMQTemplate extRocketMQTemplate;

        //key time value ids
        ConcurrentHashMap<Long, MpscArrayQueue<Long>> timeWheel;

        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();

        Executor loadExecutor = Executors.newSingleThreadExecutor();
        Executor clearExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("abc").build());

        // 想做分片的
        // private static final int threads = 4;

        private AtomicInteger expireCount = new AtomicInteger();

        public void init() {

            hashedWheelTimer.start();

            loadExecutor.execute(() -> {
                System.out.println("start");

                System.out.println("end");
            });
            clearExecutor.execute(() -> {
                System.out.println("start");

                System.out.println("end");
            });
            Runtime.getRuntime().addShutdownHook(new Thread(() -> hashedWheelTimer.stop()));
        }

        public void load() {
            //数据库读取的分片
        }

        public void task() {
            List<DelayMsg> delayMsgs = findByTriggerTimeAfterAndStatus(new Date(), 0);
            for (DelayMsg delayMsg : delayMsgs) {
                //典型的但生产者多消费者。
                hashedWheelTimer.newTimeout(new TimerTask() {
                    @Override
                    public void run(Timeout timeout) throws Exception {
                        SendResult sendResult = extRocketMQTemplate.send(delayMsg.getTopic(), delayMsg.getTag(), delayMsg.getBody());
                        if (delayMsg.getTriggerTime().getTime() - System.currentTimeMillis() > 100 && (expireCount.getAndIncrement() & 123) == 0) {
                            System.out.println("info 有点超时了诶");
                        }
                        //update status of delay
                    }
                }, 1, TimeUnit.SECONDS);

            }
        }


        //limit 1000 order by create time
        public List<DelayMsg> findByTriggerTimeAfterAndStatus(Date date, int status) {
            return null;
        }
    }
}
