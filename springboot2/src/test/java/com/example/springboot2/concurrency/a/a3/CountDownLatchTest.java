package com.example.springboot2.concurrency.a.a3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 *同步工具类
 */
public class CountDownLatchTest {
    final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        new Worker("1",1000,countDownLatch).start();
        new Worker("2",500,countDownLatch).start();
        countDownLatch.await();
        System.out.println("ok");
    }

    static class Worker extends Thread {

        String workname;
        int worktime;
        CountDownLatch countDownLatch;

        public Worker(String workname, int worktime, CountDownLatch countDownLatch) {
            this.workname = workname;
            this.worktime = worktime;
            this.countDownLatch = countDownLatch;
        }



        @Override
        public void run() {
            System.out.println("Worker "+workname+" do work begin at "+sdf.format(new Date()));
            try {
                Thread.sleep(worktime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker "+workname+" do work complete at "+sdf.format(new Date()));
            countDownLatch.countDown();//工人完成工作，计数器减一
        }
    }
}
