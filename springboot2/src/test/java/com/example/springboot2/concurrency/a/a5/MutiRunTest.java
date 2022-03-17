package com.example.springboot2.concurrency.a.a5;

import org.joda.time.DateTime;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * quartz  错误missed fire
 */
public class MutiRunTest {

    private static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    private static int i = 0;

    public static void main(String[] args) {

        DateTime now = DateTime.now();
        System.out.println(DateTime.now());
//        while (DateTime.now().isBefore(now.plusSeconds(1))) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                i++;
                try {
//                                Thread.sleep((long) (new Random().nextDouble()*500));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        }
//            }).run();
//        }
        System.out.println(DateTime.now());
        System.err.println(i);
    }
}
