package com.example.springboot2.concurrency.a.a4;

import java.util.PriorityQueue;

/**
 * 生产者消费者
 */
public class ProducerConsumerTest1 {

    public static Object object = new Object();

    private static int queueSize = 10;
    private static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Consumer consumer=new Consumer();
        Producer producer=new Producer();
        consumer.start();
        producer.start();
    }

    static class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    Integer poll = queue.poll();//移走队首元素
                    queue.notify();
                    System.out.println("从队列取走一个元素" + poll + "，队列剩余" + queue.size() + "个元素");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    static class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
