package com.example.springboot2.concurrency.a.a1;

import java.util.concurrent.*;

/**
 * Created by jowang on 2017/1/2 0002.
 */
public class BlockTest {

//    BlockingQueue<Integer> blockingQueue=new



    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<Integer>(10,false);
        BlockingQueue<Integer> blockingQueue1=new LinkedBlockingDeque<>();
        BlockingQueue<Integer> blockingQueue2=new LinkedBlockingDeque<>();
        LinkedBlockingDeque<Integer> linkedBlockingDeque=new LinkedBlockingDeque<>();
//        linkedBlockingDeque.offer()

        //堆实现
        PriorityBlockingQueue<Integer> priorityBlockingQueue=new PriorityBlockingQueue<>();
//        priorityBlockingQueue.


        System.out.println(System.nanoTime());

        DelayQueue delayQueue=new DelayQueue();
        Delayed delayed = new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        };


//        delayed.getDelay(TimeUnit.SECONDS);

//        BlockingDeque<Integer> blockingDeque=new PriorityBlockingQueue<Integer>();
    }
//    static class
}
