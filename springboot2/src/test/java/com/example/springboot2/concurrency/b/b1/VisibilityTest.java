package com.example.springboot2.concurrency.b.b1;
// Broken! - How long would you expect this program to run? - Page 259

import java.util.concurrent.TimeUnit;

/**
 * 线程可见性测试
 */
public class VisibilityTest {
    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                System.out.println(i);

                //在java虚拟机中会‘聪明’编译  while (!stopRequested) i++ =while(!stopRequested) while(true) i++;
                while (!stopRequested) {
//                    i++;
                    System.out.println(i);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        System.out.println("ok");
    }
}

class VisibilityTest2 {
   private static volatile boolean stopRequested;

   public static void main(String[] args)
           throws InterruptedException {
       Thread backgroundThread = new Thread(new Runnable() {
           public void run() {
               int i = 0;
               System.out.println(i);

               //在java虚拟机中会‘聪明’编译  while (!stopRequested) i++ =while(!stopRequested) while(true) i++;
               while (!stopRequested) {
                   System.out.println(i);
               }
           }
       });
       backgroundThread.start();

       TimeUnit.SECONDS.sleep(1);
       stopRequested = true;
       System.out.println("ok");
   }
}
