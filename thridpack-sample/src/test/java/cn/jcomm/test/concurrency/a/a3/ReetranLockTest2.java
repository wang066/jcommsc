package cn.jcomm.test.concurrency.a.a3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jowang on 2017/3/5 0005.
 */
public class ReetranLockTest2 {
    public static ReentrantLock reentrantLock = new ReentrantLock();


    public static class TryGetLock implements Runnable {

        @Override
        public void run() {
            try {
                boolean b = reentrantLock.tryLock(1, TimeUnit.SECONDS);
                if (b) {
                    System.out.println("ok");
                }else {
                    System.out.println("not");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ReetranLockTest2 reetranLockTest2 = new ReetranLockTest2();
        reetranLockTest2.reentrantLock.lock();
        reetranLockTest2.reentrantLock.lock();
        System.out.println(reetranLockTest2.reentrantLock.getHoldCount());
        reetranLockTest2.reentrantLock.unlock();
        System.out.println(reetranLockTest2.reentrantLock.getHoldCount());
        new TryGetLock().run();
        reetranLockTest2.reentrantLock.unlock();
        System.out.println(reetranLockTest2.reentrantLock.getHoldCount());
    }
}
