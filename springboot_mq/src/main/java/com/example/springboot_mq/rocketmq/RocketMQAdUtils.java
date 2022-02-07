package com.example.springboot_mq.rocketmq;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

public class RocketMQAdUtils {
    private static final String FORMAT_DELIMITER = "%s:%s";

    public enum DelayTimeLevel {
        /**
         * 此为默认
         * 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
         */
        DEFAULT_0(0, TimeUnit.SECONDS.toMillis(0)),
        SECOND_1(1, TimeUnit.SECONDS.toMillis(1)),
        SECOND_5(2, TimeUnit.SECONDS.toMillis(5)),
        SECOND_10(3, TimeUnit.SECONDS.toMillis(10)),
        SECOND_30(4, TimeUnit.SECONDS.toMillis(30)),
        MINUTE_1(5, TimeUnit.MINUTES.toMillis(1)),
        MINUTE_2(6, TimeUnit.MINUTES.toMillis(2)),
        MINUTE_3(7, TimeUnit.MINUTES.toMillis(3)),
        MINUTE_4(8, TimeUnit.MINUTES.toMillis(4)),
        MINUTE_5(9, TimeUnit.MINUTES.toMillis(5)),
        MINUTE_6(10, TimeUnit.MINUTES.toMillis(6)),
        MINUTE_7(11, TimeUnit.MINUTES.toMillis(7)),
        MINUTE_8(12, TimeUnit.MINUTES.toMillis(8)),
        MINUTE_9(13, TimeUnit.MINUTES.toMillis(9)),
        MINUTE_10(14, TimeUnit.MINUTES.toMillis(10)),
        MINUTE_20(15, TimeUnit.MINUTES.toMillis(20)),
        MINUTE_30(16, TimeUnit.MINUTES.toMillis(30)),
        HOUR_1(17, TimeUnit.HOURS.toMillis(1)),
        HOUR_2(18, TimeUnit.HOURS.toMillis(2)),
        ;

        private int level;

        private long millis;

        DelayTimeLevel(int level, long millis) {
            this.level = level;
            this.millis = millis;
        }

        public int getLevel() {
            return level;
        }

        public long getMillis() {
            return millis;
        }
    }


    public static String destination(String topic, String tag) {
        if (StringUtils.isEmpty(tag)) {
            return topic;
        }
        return String.format(FORMAT_DELIMITER, topic, tag);
    }

    public static String destination(String topic) {
        return destination(topic, null);
    }
}
