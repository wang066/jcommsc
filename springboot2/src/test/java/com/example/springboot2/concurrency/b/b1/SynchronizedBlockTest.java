package com.example.springboot2.concurrency.b.b1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 066 on 2017/3/7 0007.
 * 锁代码块
 */
public class SynchronizedBlockTest {


    /**
     * 锁对象
     */
    public int get(){
        System.out.println("1");
        synchronized (this){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 锁字段
     */
    private  Object lock=new Object();
    public int get2(){
        System.out.println("1");
        synchronized (lock){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        SynchronizedBlockTest t=new SynchronizedBlockTest();

        for (int i = 0; i < 2; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    t.get();
                }
            });
        }

//        for (int i = 0; i < 2; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    t.get2();
//                }
//            });
//        }




//        Thread.sleep(3000);
    }

}
