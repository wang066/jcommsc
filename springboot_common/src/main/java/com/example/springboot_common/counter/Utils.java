package com.example.springboot_common.counter;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

public class Utils {
    @Getter
    @Setter
    public static class Record {
        long id;
        long bizId;
        long userId;
        int status;
    }

    public static class Count {
        long id;
        long bizId;
        int count;
    }

    // struct item{
    //     int64_t id;
    //     int star_num;
    //     unsigned short repost_num; 转发数
    //     unsigned short comment_num;评论数
    // };

    public static class MQUtil {
        public static void send(Object obj) {

        }

        public static void consume(Object object, Function<Object, Object> function) {

        }
    }

    public static class DBUtil {
        //保存记录
        public static void saveRecod(Record record) {

        }

        public void saveCount(Count count) {

        }
    }
}
