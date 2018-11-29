package cn.jcomm.test.concurrency.b.b4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

/**
 * Created by jowang on 2018/4/22 0022.
 */
public class LockTest extends TestCase {

    public void test1() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sleep finish");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("finish");
    }

    public void test2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                latch.countDown();
                System.out.println(1);
                latch.countDown();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(0);
            }
        });
        t.start();

        latch.await();

        System.out.println("finish");

        t.join();
    }

    public void test3() throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
            }
        });
        System.out.println(cyclicBarrier.getNumberWaiting());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                try {
                    cyclicBarrier.await(1,TimeUnit.DAYS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(4);
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(1);
        cyclicBarrier.await(1,TimeUnit.DAYS);
        System.out.println("sleep");
        Thread.sleep(1000);


        cyclicBarrier.reset();
        System.out.println(cyclicBarrier.getNumberWaiting());
    }

    public void test4() throws  InterruptedException {
        Exchanger<String> exchanger=new Exchanger<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String A= "A";
                try {
                    Thread.sleep(1000);
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String B="B";
                String A="";

                try {
                     A=exchanger.exchange(B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(A);
                System.out.println(B);
                System.out.println(A.equals(B));
            }
        });

        executorService.awaitTermination(1,TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
