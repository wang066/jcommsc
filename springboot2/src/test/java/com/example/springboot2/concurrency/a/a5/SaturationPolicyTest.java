package com.example.springboot2.concurrency.a.a5;

import java.util.concurrent.*;

/**
 *
 */
public class SaturationPolicyTest {

    public static class MyPolicy implements RejectedExecutionHandler {


        private int SLEEP_MICROSECONDS = 10;

        public MyPolicy(int sleep_microseconds) {
            SLEEP_MICROSECONDS = sleep_microseconds;
        }

        /**
         * Always throws RejectedExecutionException.
         *
         * @param r the runnable task requested to be executed
         * @param e the executor attempting to execute this task
         * @throws RejectedExecutionException always
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            try {
                TimeUnit.MICROSECONDS.sleep(SLEEP_MICROSECONDS);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            e.execute(r);
        }
    }


    public static void policy(RejectedExecutionHandler handler) {
        //基本线程2个，最大线程数为3，工作队列容量为5
        ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 3, 0l, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(5));
        if (handler != null) {
            exec.setRejectedExecutionHandler(handler);//设置饱和策略
        }
        for (int i = 0; i < 10; i++) {
            exec.execute(new Task());//提交任务
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
//        policy(new ThreadPoolExecutor.AbortPolicy());//1.Abort策略：新任务提交时直接抛出未检查的异常RejectedExecutionException，该异常可由调用者捕获。
//        policy((new ThreadPoolExecutor.CallerRunsPolicy()));//2.CallerRuns策略：为调节机制，既不抛弃任务也不抛出异常，而是将某些任务回退到调用者。不会在线程池的线程中执行新的任务，而是在调用exector的线程中运行新的任务。
//        policy(new ThreadPoolExecutor.DiscardPolicy());//新提交的任务被抛弃。
//        policy(new ThreadPoolExecutor.DiscardOldestPolicy());//4.DiscardOldest策略：队列的是“队头”的任务，然后尝试提交新的任务。（不适合工作队列为优先队列场景）

        policy(new MyPolicy(100));
    }

    //自定义任务
    static class Task implements Runnable {
        private static int count = 0;
        private int id = 0;//任务标识

        public Task() {
            id = ++count;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);//休眠3秒
            } catch (InterruptedException e) {
                System.err.println("线程被中断" + e.getMessage());
            }
            System.out.println(" 任务：" + id + "\t 工作线程: " + Thread.currentThread().getName() + " 执行完毕");
        }
    }

}
