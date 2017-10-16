package cn.jcomm.test.thridpack.packtest.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * redis 发布订阅 队列测试
 * 在输入框中输入 hello
 * http://www.cnblogs.com/yepei/p/5662673.html
 * 2个sub 是广播模式的
 */
public class PubSubTest {
    public static void main(String[] args) {
        // 替换成你的reids地址和端口
        //192.168.1.52
        String redisIp = "192.168.1.52";
//        String redisIp = "127.0.0.1";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

        SubThread subThread = new SubThread(jedisPool);
        subThread.start();

        SubThread subThread2 = new SubThread(jedisPool);
        subThread2.start();

        Publisher publisher = new Publisher(jedisPool);
        publisher.start();


//        Publisher publisher2 = new Publisher(jedisPool);
//        publisher2.start();
    }
}

class SubThread extends Thread {
    private final JedisPool jedisPool;
    private final Subscriber subscriber = new Subscriber();

    private final String channel = "mychannel";

    public SubThread(JedisPool jedisPool) {
        super("SubThread");
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        System.out.println(String.format("subscribe redis, channel %s, concurrent will be blocked", channel));
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(subscriber, channel);
        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}


class Publisher {
    private final JedisPool jedisPool;

    public static int i;

    public Publisher(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Jedis jedis = jedisPool.getResource();
        while (true) {
            String line = "this is a message";
            try {
//                line = reader.readLine();
                if (!"quit".equals(line)) {
                    i++;
                    jedis.publish("mychannel", line);
                    System.out.println("发布了" + i);
                    Thread.sleep(500);//500ms 生产一条消息
                    if(i>10) Thread.sleep(5000);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Subscriber extends JedisPubSub {

    public static int i;

    public void onMessage(String channel, String message) {
//        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
        try {
            i++;
            System.out.println("接收了" + i);
            Thread.sleep(1000);//500ms 生产一条消息
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPMessage(String s, String s1, String s2) {

    }

    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d",
                channel, subscribedChannels));

    }

    @Override
    public void onPUnsubscribe(String s, int i) {

    }

    @Override
    public void onPSubscribe(String s, int i) {

    }
}
