package com.example.springboot_common.counter;

public class Weibo {

    public static class MyController {

        public int getCount(String id) {
            return 0;
        }

        public void increment(String id) {

        }
    }

    public interface ICount {
        void incre(long id);

        long get(long id);
    }

    public interface DBCount extends ICount {
    }

    public interface RedisCount extends ICount {
    }
}
