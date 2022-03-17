package com.example.springboot2.concurrency.b.b3;

import sun.misc.Unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jowang on 2017/6/8 0008.
 */
public class _Test2 {
    static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    private volatile int i = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(integerThreadLocal.get());
                    integerThreadLocal.set(1);
                    System.out.println(integerThreadLocal.get());
                }
            });
        }
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();

        System.out.println("ok");
    }

    public void test1() throws Exception {
        i = i++;
    }

    public void testUnsafe() throws Exception {
        Unsafe unsafe = Unsafe.getUnsafe();
//unsafe.compareAndSwapInt()这几个参数的意义
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(1, 2);//内存地址，偏移量 备份的旧数据，新数据
    }

    //    public void test2() throws Exception {
//       Thread t1=new Thread(new Runnable() {
//           @Override public void run() {
//               System.out.println("1--------------"+i);
//               i++;
//           }
//       });
//        Thread t2=new Thread(new Runnable() {
//            @Override public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                i++;
//                System.out.println("2--------------"+i);
//            }
//        });
//        t1.start();
//        t2.start();
//
//        Thread.sleep(3000);
//    }


}
