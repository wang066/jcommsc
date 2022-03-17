package com.example.springboot2.concurrency.a.a1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 */
public class CapacityTest {
    public static void main(String[] args) {
//        ArrayList list=new ArrayList(10);
//        for (int i = 0; i < 20; i++) {
//            list.add(i);
//        }
//        list.forEach(i-> System.out.println(i));

        System.out.println("------------------------------");

        BlockingQueue blockingQueue=new ArrayBlockingQueue(10);
        for (int i = 0; i < 10; i++) {
            blockingQueue.add(i);
        }
        blockingQueue.forEach(i-> System.out.println(i));
    }
}
