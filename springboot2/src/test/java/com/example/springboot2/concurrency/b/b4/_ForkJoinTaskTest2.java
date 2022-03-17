package com.example.springboot2.concurrency.b.b4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _ForkJoinTaskTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        锁
//        ReentrantLock
//        CountDownLatch
//        Semaphore
//        acquire
//        Thread t;

        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Integer> submit = pool.submit(new CountTask(1, 4));
        System.out.println(submit.get());

    }

    public static class CountTask extends RecursiveTask<Integer> {

        private static final int THREA_HOLD = 2;

        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            boolean canCompute = (end - start) <THREA_HOLD;
            if (canCompute) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                int middle = (start + end) / 2;
                CountTask left = new CountTask(start, middle);
                CountTask right = new CountTask(middle + 1, end);
                left.fork();
                right.fork();
                int leftResult = left.join();
                System.out.println(leftResult);
                int rightResult = right.join();
                System.out.println(rightResult);
                sum = leftResult + rightResult;
            }
//            System.out.println(sum);
            return sum;
        }
    }
}
