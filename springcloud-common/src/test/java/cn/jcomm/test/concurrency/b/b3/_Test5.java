package cn.jcomm.test.concurrency.b.b3;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by jowang on 2017/6/19 0019.
 */
public class _Test5 extends TestCase {
    public static void main(String[] args) {
//        ConcurrentStack
//        AtomicReference<>
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.size();
        concurrentHashMap.mappingCount();
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));
        AbstractQueuedSynchronizer abstractQueuedSynchronizer;
//        for (int i = 0; i < 100; i++) {
//            executorService.submit(new Runnable() {
//                @Override public void run() {
//                    try {
//                        Thread.sleep(1000);
//                        System.out.println(DateTime.now());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

//                    System.out.println("1");
//                    throw new RuntimeException(" 测试 是否会起新线程");
//                }
//            });
//        }

//        ReentrantLock
        Object obj = null;
//        System.out.println(obj.equals(null));
        System.out.println(1 < 30);
//        System.out.println(String.valueOf(Math.pow(2, 30)));

    }

    public void test1() throws Exception {

        System.out.println(Integer.parseInt("0001111", 2));
        System.out.println(Integer.parseInt("0011111", 2));
        System.out.println(Integer.parseInt("0111111", 2));
        System.out.println(Integer.parseInt("111111", 2));

        System.out.println(Integer.parseInt("0001111", 2) & 15);
        System.out.println(Integer.parseInt("0011111", 2) & 15);
        System.out.println(Integer.parseInt("0111111", 2) & 15);
        System.out.println(Integer.parseInt("111111", 2) & 15);

        int i1 = 1, i2 = 2;
        if ((i1 = i2) > 0) {
            System.out.println("ok");
        }
    }

    public void test2() throws Exception {

        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("ok");
    }

    public void test3() throws Exception {
        String s=new String("1");
        String s1="1";

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (new String("1")){
                    try {
                        Thread.sleep(1000);
                        System.out.println("1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (new String("1")){
                    try {
                        Thread.sleep(1000);
                        System.out.println("2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
    }
}
