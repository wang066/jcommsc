package cn.jcomm.test.other;//package cn.jcomm.test.thridpack.mytest;
//
//import org.redisson.Redisson;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by jowang on 2016/11/21 0021.
// */
//public class RedissionLockTest {
//    private static RedissonClient redisson;
//
//    public static void acquire(String lockName) {
//        String key = "lock" + lockName;
//        RLock mylock = getRedisson().getLock(key);
//        mylock.lock(100, TimeUnit.MICROSECONDS); //lock提供带timeout参数，timeout结束强制解锁，防止死锁
//        System.out.println("======lock======" + Thread.currentThread().getName());
//    }
//
//    public static void release(String lockName) {
//        String key = "lock" + lockName;
//        RLock mylock = getRedisson().getLock(key);
//        mylock.unlock();
//        System.out.println("======unlock======" + Thread.currentThread().getName());
//    }
//
//    public static RedissonClient getRedisson() {
//        if (redisson != null) {
//            return redisson;
//        }
//        Config config = new Config();
//        config.useSingleServer().setAddress("localhost:6379").setConnectionPoolSize(5);
//        RedissonClient redisson = Redisson.create(config);
//        RedissionLockTest.redisson = redisson;
//        return redisson;
//    }
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        String key = "test123";
//                        acquire(key);
//                        Thread.sleep(100); //获得锁之后可以进行相应的处理
//                        System.out.println("======获得锁后进行相应的操作======");
//                        release(key);
//                        System.out.println("=============================");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            t.start();
//        }
//        System.out.println("=============================");
//    }
//}
