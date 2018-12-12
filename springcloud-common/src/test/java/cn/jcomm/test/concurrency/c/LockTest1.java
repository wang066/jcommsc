package cn.jcomm.test.concurrency.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: jowang
 * @date: 2018-12-06 16:01
 * @description:
 */
public class LockTest1 {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        Thread thread = new Thread((Runnable) () -> {
            reentrantLock.lock();
            try {
                System.out.println("我要等一个新信号" + 1);
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("拿到一个信号！！" + 1);
            reentrantLock.unlock();
        }, "waitThread1");

        thread.start();

        Thread thread1 = new Thread((Runnable) () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.lock();
            System.out.println("我拿到锁了");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("我发了一个信号！！");
            reentrantLock.unlock();
        }, "signalThread");

        thread1.start();

        TimeUnit.SECONDS.sleep(10);
    }
}
