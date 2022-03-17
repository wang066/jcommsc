package com.example.springboot2.concurrency.c;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * @author: jowang
 * @date: 2018-11-27 15:42
 * @description:
 */
public class _ThreadTest4 {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("thenAcceptAsync message")
                .thenAcceptAsync(s -> {
                    result.append(s);
                    System.out.println(result);
                });
        cf.join();

        CompletableFuture.allOf(CompletableFuture.completedFuture("a").handle((s, throwable) -> {

            System.out.println("1");
            return "b";
        }));
        assertTrue("Result was empty", result.length() > 0);


    }

    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> submit = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 1;
        });
        System.out.println(submit.get());

        //TimeUnit.SECONDS.sleep(2);
    }

    public void test2() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Run supplyAsync.");
            return "Return result of Supply Async";
        });

        future.thenRun(() -> {
            System.out.println("then run");
        });

        future.whenComplete((v, e) -> {
            System.out.println("WhenComplete value: " + v);
            System.out.println("WhenComplete exception: " + e);
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Return result of Run Async.");
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            return "world";
        });
        CompletableFuture<String> f = future3.thenCombine(future4,
                (x, y) -> x + "-" + y);

        System.out.println(f.get());
    }

    public void test4() throws Exception {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        //MoreExecutors.getExitingScheduledExecutorService()
        // 执行任务
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("新任务。。。");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }

        });
        // 任务完成回掉函数
        final FutureCallback<Integer> futureCallback = new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("任务执行成功，对任务进行操作。");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("任务执行失败。");
            }
        };

        // 绑定任务以及回调函数
        Futures.addCallback(listenableFuture, futureCallback);
    }

    public void test5() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(1, 5).forEach((t) -> {
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    TimeUnit.SECONDS.sleep(t);
                    System.out.println(t);
                    return "ok";
                }
            });
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(executorService.isShutdown());

        //executorService.invokeAll()
        //while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
        //    System.out.println("running");
        //}


        //executorService.isShutdown()
    }
}
