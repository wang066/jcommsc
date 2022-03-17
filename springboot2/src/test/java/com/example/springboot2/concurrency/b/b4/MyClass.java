package com.example.springboot2.concurrency.b.b4;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: jowang
 * @date: 2018-06-07 20:23
 * @description:
 */
public class MyClass {
    private int i = 0;

    public static void main(String[] args) {
//        MyClass m=new MyClass();
//        System.out.println(m.i++);
    }

    public void test1() throws InterruptedException {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello:" + DateTime.now().toString(DateTimeFormat.fullDateTime()));
            }
        }, 0, 3, TimeUnit.SECONDS);

        Thread.sleep(10000);
    }
}
