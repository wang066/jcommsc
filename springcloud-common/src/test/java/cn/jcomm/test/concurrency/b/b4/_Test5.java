package cn.jcomm.test.concurrency.b.b4;

import org.joda.time.DateTime;

import java.util.concurrent.*;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test5 {

    static ThreadLocal<Integer> i = new ThreadLocal<>();

    public static void main(String[] args) {
//        i.set(1);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(() -> System.out.println(i.get()));//print null
//        executorService.shutdown();

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        System.out.println(queue.poll());
        System.out.println("poll");
        System.out.println(queue.peek());
        System.out.println("peek");

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        LinkedBlockingQueue blockingQueue =new LinkedBlockingQueue();
        try {
            System.out.println(DateTime.now());
            System.out.println(blockingQueue.poll(1, TimeUnit.SECONDS));
            System.out.println(DateTime.now());
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("take");

    }

}
