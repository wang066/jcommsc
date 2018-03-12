package cn.jcomm.test.concurrency.a.a1;

import org.joda.time.DateTime;

import java.util.concurrent.TimeUnit;

/**
 * Created by jowang on 2016/12/28 0028.
 * join 等待线程
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

//        System.out.println(DateTime.now());
//        Thread t2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
////                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//   Thread t1=   new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                    t2.join();
//                    System.out.println(DateTime.now());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//
//        System.out.println(DateTime.now());

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(DateTime.now());
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(DateTime.now());
//                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();

//        Thread.NORM_PRIORITY;
//        Thread.MAX_PRIORITY;
//        Thread.MIN_PRIORITY


    }
}
