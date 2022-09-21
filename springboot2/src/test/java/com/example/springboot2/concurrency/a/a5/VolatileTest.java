package com.example.springboot2.concurrency.a.a5;

import org.joda.time.DateTime;

import java.util.concurrent.*;

/**
 * 看下指令重排
 */
public class VolatileTest {
    private static boolean stop;
    public static void main(String[] args) throws InterruptedException {
        Thread workThread = new Thread(new Runnable() {
            public void run() {
                int i= 0;
                while (!stop) {
                    i++;
                    try{
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(DateTime.now());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        workThread.start();
        TimeUnit.SECONDS.sleep(3);
        stop = true;

        TimeUnit.SECONDS.sleep(10);
    }
}
