package cn.jcomm.test.concurrency.a.a5;

import java.util.concurrent.*;

/**
 * 信号量
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        Semaphore semaphore=new Semaphore(5);
        for (int i = 0; i < 20; i++) {

            final int NO=i;
            Runnable r=new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("Accessing: " + NO);
                        int i1 = ThreadLocalRandom.current().nextInt(1000);
//                        System.out.println(i1);
                        TimeUnit.MILLISECONDS.sleep(i1);
                        semaphore.release();
                        System.out.println("-----------------"+semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

//            Thread t=new Thread(r);
//            t.start();
            exec.execute(r);
        }

        exec.shutdown();



    }
}
