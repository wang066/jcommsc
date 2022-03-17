package com.example.springboot2.concurrency.a.a5;

/**
 *. 为什么在执行wait, notify时，必须获得该对象的锁？
 这是因为，如果没有锁，wait和notify有可能会产生竞态条件(Race Condition)。
 */
public class TheadNotifyWait {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Object lock = new Object();
        synchronized (lock) {
            obj.wait();
            obj.notify();
        }

    }
}
