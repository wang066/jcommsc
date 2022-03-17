package com.example.springboot2.concurrency.b.b1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * volatile 计数问题
 * voldtile 只保证 取值的时候是内存中的值 而计算的时候并不保证 也就是说计算不是原子性的
 */
public class CountTest1 {
    private static volatile int i;
//    int i;
//    double d;

    public static void main(String[] args) throws InterruptedException {
        i=0;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int j = 0; j < 10000; j++) {
            executorService.submit(new Runnable() {
                public void run() {
                    i++;
                }
            });
        }
        executorService.shutdown();
        if (!executorService.isTerminated()) {
            Thread.sleep(10);
        }
        System.out.println(i);
    }
}
