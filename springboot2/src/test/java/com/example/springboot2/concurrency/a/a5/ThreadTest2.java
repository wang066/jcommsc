package com.example.springboot2.concurrency.a.a5;

import org.joda.time.DateTime;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 066 on 2017/2/17 0017.
 * 执行结果是什么
 * 因为覆盖
 */
public class ThreadTest2 {
    static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 2, 1, TimeUnit.DAYS, new ArrayBlockingQueue<>(1));

    public static void main(String[] args) {
        // executorService.setMaximumPoolSize(3);
        // executorService.setCorePoolSize(2);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        System.out.println(executorService.getActiveCount());
        System.out.println(executorService.getQueue().size());
    }

}
