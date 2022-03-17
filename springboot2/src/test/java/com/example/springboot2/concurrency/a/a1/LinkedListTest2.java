package com.example.springboot2.concurrency.a.a1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class LinkedListTest2 {

    static class Work implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService= new ThreadPoolExecutor(10, 10, 5,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Work());
        }

        System.out.println("all commit ");
    }
}
