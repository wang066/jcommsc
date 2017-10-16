//package cn.jcomm.test.thridpack.packtest.redis;
//
//import junit.framework.TestCase;
//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// *
// */
//public class RedisMQTest extends TestCase {
//
//    public void test() throws InterruptedException {
//
////        List<String> ss= Arrays.asList("1","2");
////        ss.forEach(i-> System.out.println(i));
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        String redisIp = "192.168.1.52";
////        String redisIp = "127.0.0.1";
//
//        int reidsPort = 6379;
//        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
//
//        executorService2.submit(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Jedis jedis = jedisPool.getResource();
//            Long rpush = jedis.rpush("testblop", "other");
//            Long rpush2 = jedis.rpush("testblop", "other");
//            Long rpush3 = jedis.rpush("testblop", "other");
//        });
//
//        executorService1.submit(() -> {
//            Jedis jedis = jedisPool.getResource();
//            System.out.println(new DateTime().toString(DateTimeFormat.fullTime()));
//            List<String> list = jedis.blpop(3000, "testblop");
//            System.out.println(new DateTime().toString(DateTimeFormat.fullTime()));
//            list.forEach(i -> {
//                System.out.println(i);
//            });
//
//        });
//
//        executorService2.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("ok");
//            }
//        });
//
//        Thread.sleep(5000);
//    }
//
//    public void test2() throws InterruptedException {
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//
//        executorService2.submit(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("ok2");
//        });
//
//        executorService1.submit(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("ok1");
//        });
//        System.out.println(new DateTime().toString(DateTimeFormat.fullTime()));
////        executorService1.awaitTermination(5, TimeUnit.SECONDS);
//        System.out.println(new DateTime().toString(DateTimeFormat.fullTime()));
//    }
//
//    public static void main(String[] args) {
//
//
////        // 替换成你的reids地址和端口
////        //192.168.1.52
////        String redisIp = "192.168.1.52";
//////        String redisIp = "127.0.0.1";
////        int reidsPort = 6379;
////        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
////        Jedis jedis = jedisPool.getResource();
////
////        Long del = jedis.del("12345435435");
////        System.out.println(del);
////
////        jedis.hset("myhashset_wang","1","1");
////        jedis.hset("myhashset_wang","2","2");
////
////
////        jedis.rpush("mylist","list","list1","list3");
////        for (int i = 0; i < 4; i++) {
////            System.out.println(jedis.lpop("mylist"));
////        }
////
////
////        jedis.close();
//
//
////demo2
//        // 替换成你的reids地址和端口
//        //192.168.1.52
//        String redisIp = "192.168.1.52";
////        String redisIp = "127.0.0.1";
//
//        int reidsPort = 6379;
//        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
//        Jedis jedis = jedisPool.getResource();
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
//        for (int i = 0; i < 10000; i++) {
//            fixedThreadPool.submit(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
//        }
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//
//    }
//
//    /**
//     * 一秒钟redis 远程服务器能写多少（单线程）
//     */
//    public void test4() {
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        String redisIp = "192.168.1.52";
////        String redisIp = "127.0.0.1";
//
//        int reidsPort = 6379;
//        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
//
//        int i = 0;
//        DateTime now = DateTime.now();
//        System.out.println(now.toString());
//        DateTime now2 = now.plusSeconds(1);
//        System.out.println(now2.toString());
//        //每秒性能3452
//        while (DateTime.now().isBefore(now2)) {
//            Jedis jedis = jedisPool.getResource();
//            Long rpush = jedis.rpush("testblop", "other");
//            jedisPool.returnResource(jedis);
////            jedis.close();
//            System.out.println(i++);
//        }
//
//
////        for (int j = 0; j < 10000; j++) {
////            Jedis jedis = jedisPool.getResource();
////            Long rpush = jedis.rpush("testblop", "other");
////        }
//        System.out.println(DateTime.now());
//        System.out.println(i);
//    }
//
//    /**
//     * 一秒钟redis 远程服务器能读多少（单线程）
//     */
//    public void test5() {
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        String redisIp = "192.168.1.52";
////        String redisIp = "127.0.0.1";
//
//        int reidsPort = 6379;
//        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
//
//        int i = 0;
//        DateTime now = DateTime.now();
//        System.out.println(now.toString());
//        DateTime now2 = now.plusSeconds(1);
//        System.out.println(now2.toString());
//        //每秒性能3000+
//        while (DateTime.now().isBefore(now2)) {
//            Jedis jedis = jedisPool.getResource();
//            List<String> list = jedis.blpop(3000, "testblop");
//            jedisPool.returnResource(jedis);
////            jedis.close();
//            System.out.println(i++);
//        }
//        System.out.println(i);
//    }
//
//    public void test6() {
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        String redisIp = "192.168.1.52";
////        String redisIp = "127.0.0.1";
//
//        int reidsPort = 6379;
//        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
//
//        DateTime now = DateTime.now();
//        System.out.println(now.toString());
//        DateTime now2 = now.plusSeconds(1);
//        System.out.println(now2.toString());
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Jedis jedis2 = jedisPool.getResource();
//                Long rpush = jedis2.rpush("testblop", "other");
//            }
//        }).start();
//
//
//        //每秒性能3000+
//        Jedis jedis = jedisPool.getResource();
//        List<String> list = jedis.blpop(0, "testblop");//无限制阻塞
//        list.forEach(i -> System.out.println(i));
//
//        System.out.println(DateTime.now().toString());
//
//
//        jedisPool.returnResource(jedis);
//    }
//
////    测试returnResource后jedis 实例是否还能用
//    public void test7(){
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        String redisIp = "192.168.1.52";
////        String redisIp = "127.0.0.1";
//
//        int reidsPort = 6379;
//        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
//        for (int i = 0; i < 100; i++) {
//            Jedis jedis = jedisPool.getResource();
//
//            Long rpush = jedis.rpush("testblop", "other");
//            jedisPool.returnResource(jedis);
////            jedis.close();
//            System.out.println(rpush);
//        }
//
//
//
//    }
//}
