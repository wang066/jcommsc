package com.example.springboot2.concurrency.a.a4;

/**
 *生产者消费者
 */
public class ProducerConsumerTest3 {

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            System.out.println((Math.random() * 500));
//        }

        ProducerConsumerTest3 t = new ProducerConsumerTest3();

        Thread t1 = new Increase(t);
        t1.setName("Increase");
        Thread t2 = new Decrease(t);
        t2.setName("Decrease");

        t1.start();
        t2.start();
    }


    private static int count;

    public synchronized void increase() {
        if (count == 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count++;
        System.out.println(Thread.currentThread().getName() + ":" + count);
        notify();
    }

    public synchronized void decrease() {
        if (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + ":" + count);
        notify();
    }


    static class Increase extends Thread implements Runnable {

        private ProducerConsumerTest3 t;

        public Increase(ProducerConsumerTest3 t) {
            this.t = t;
        }

        @Override
        public void run() {
//        for (int i = 0; i < 300; i++) {
//            try {
//                Thread.sleep((long) (Math.random() * 200));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            t.increase();
//        }
            while (true) {
                t.increase();
                try {
                    Thread.sleep((long) (Math.random() * 200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    static class Decrease extends Thread implements Runnable {

        private ProducerConsumerTest3 t;

        public Decrease(ProducerConsumerTest3 t) {
            this.t = t;
        }

        @Override
        public void run() {
//        for (int i = 0; i < 300; i++) {
//            try {
//                Thread.sleep((long) (Math.random() * 200));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            t.decrease();
//        }

            while (true) {
                t.decrease();
                try {
                    Thread.sleep((long) (Math.random() * 200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

