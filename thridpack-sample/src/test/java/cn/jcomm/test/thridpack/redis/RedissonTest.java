package cn.jcomm.test.thridpack.redis;//package cn.jcomm.test.thridpack.mytest;
//
//import org.junit.Test;
//import org.redisson.Redisson;
//import org.redisson.api.RMap;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//
///**
// * Created by jowang on 2016/11/20 0020.
// */
//
//public class RedissonTest {
//
//    @Test
//    public void test() {
//        Config config = new Config();
//        config.useSingleServer().setAddress("localhost:6379").setConnectionPoolSize(5);
//        RedissonClient redisson = Redisson.create(config);
//        RMap<Integer, Integer> rMap = redisson.getMap("myMap");
//        rMap.put(1, 1);
//        rMap.put(2, 2);
//
//        RMap<Integer, Integer> map2 = redisson.getMap("myMap");
//        System.out.println(rMap.get(1));
//
////
////        RExecutorService executor = redisson.getExecutorService("myExecutorService");
//    }
//
//    //redlock _test
//    @Test
//    public void test2() {
//
//        Config config = new Config();
//        config.useSingleServer().setAddress("localhost:6379").setConnectionPoolSize(5);
//        RedissonClient redisson = Redisson.create(config);
//        //这里 _redis lock 可重入 同个线程
////        RLock lock = redisson.getLock("1");
////        Assert.assertFalse(lock.isLocked());
////        lock.lock(30, TimeUnit.MINUTES);
////        Assert.assertTrue(lock.isLocked());
////        RLock lock2 = null;
////        try {
////             lock2 = redisson.getLock("1");
////        }catch (Exception e){
////            e.printStackTrace();
////            System.out.println("ok");
////        } finally {
////            if (lock != null) {
////                lock.unlock();
////            }
////            Assert.assertFalse(lock.isLocked());
////            if (lock2 != null) {
////                lock2.unlockAsync();
////            }
////        }
//
//
//    }
//
//
//    @Test
//    public void test3() throws InterruptedException {
//
////        Config config = new Config();
////        config.useSingleServer().setAddress("localhost:6379").setConnectionPoolSize(5);
////        RedissonClient redisson = Redisson.create(config);
////
////        long watch = System.currentTimeMillis();
////
////        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
////
////        pool.execute(() -> {
////        redisson.getLock("1").lock();
////        });
////
////        RLock lock = redisson.getLock("1");
////        pool.shutdown();
////        Assert.assertTrue(pool.awaitTermination(3L, TimeUnit.MINUTES));
////
////        System.out.println(System.currentTimeMillis() - watch);
//
//
//    }
//
//    @Test
//    public void test4() {
//    }
//}
