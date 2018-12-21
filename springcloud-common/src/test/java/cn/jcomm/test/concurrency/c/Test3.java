package cn.jcomm.test.concurrency.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import junit.framework.TestCase;

/**
 * @author: jowang
 * @date: 2018-11-21 11:17
 * @description:
 */
public class Test3 extends TestCase {

    public void test1() {
        //var consumer=()->{};
        //final
        //var example=new ArrayList<>();
        //lombok.val i=0;
        //i++;

        lombok.var i = 0;
        i++;
        System.out.println(i);

        //var
    }

    public void test2() {


        //java 协变 逆变 pecs producer extend consumer super
        List<String> src = new ArrayList<String>();
        src.add("111");
        src.add("222");
        src.add("333");
        src.add("444");
        List<String> dest1 = new ArrayList<String>();
        Collections.addAll(dest1, new String[src.size()]);
        Collections.copy(dest1, src);
        for (Object s : dest1) {
            System.out.println(s);
        }
    }

    public void test4() {
        System.out.println(JSON.toJSONString(ThreadLocalRandom.current().ints().limit(10).toArray()));
    }

    public void test5() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
            });
        }

        //System.out.println(executorService.);
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(executorService.isTerminated());
        }
        //executorService.awaitTermination(1,TimeUnit.HOURS);

        //System.out.println("all finsh");
    }


    public void test3() throws Exception {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        //BlockingQueue queue1=new RedissonBlockingDeque()
        ExecutorService pushTheads = Executors.newFixedThreadPool(5);
        ExecutorService popTheads = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            pushTheads.submit(() -> {
                try {
                    queue.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            popTheads.submit(() -> {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(5);
    }

    public void test6() {
        List<Integer> src = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        System.out.println(src.size());
        List<Integer> dist = new ArrayList<>(src.size());
        Collections.addAll(dist, new Integer[src.size()]);
        Collections.copy(dist, src);
        dist.forEach(System.out:: println);
    }

    public void test7() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("msg");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }


    public void test8() throws InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            assertTrue(Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().isDaemon());
        });
        assertFalse(cf.isDone());
        TimeUnit.SECONDS.sleep(1);
        assertTrue(cf.isDone());
    }

    public void test10() throws InterruptedException {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            assertFalse(Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        System.out.println("aaaa");
        //assertEquals("MESSAGE", cf.getNow(null));
    }



    public void test11() throws InterruptedException, ExecutionException {

         ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
            int count = 1;
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "custom-executor-" + count++);
            }
        });
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            //assertTrue(Thread.currentThread().getName().startsWith("custom-executor-"));
            assertFalse(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        }, executor);
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
        //executor.shutdown();
    }

    public void test12() throws InterruptedException {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> result.append(s1 + s2));
        System.out.println(result.toString());
        assertEquals("MESSAGEmessage", result.toString());
    }

    public void test13() throws InterruptedException, ExecutionException {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep( rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep( rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        CompletableFuture<Void> f =  CompletableFuture.allOf(future1,future2);
        //CompletableFuture<Object> f =  CompletableFuture.anyOf(future1,future2);
        System.out.println(f.get());
    }

    public void testGurva() {
        //Futures.allAsList()
        ListenableFuture<List<Integer>> futureList = Futures.allAsList(ListenableFutureTask.create(() -> System.out.print(10), 20));

    }

    public void test14() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<Void> f =  future.thenAcceptBoth(CompletableFuture.completedFuture(10), (x, y) -> System.out.println(x * y));
        System.out.println(f.get());
    }

    public void test15() throws IOException {
        final CompletableFuture<Integer> f = new CompletableFuture<>();
        class Client extends Thread {
            CompletableFuture<Integer> f;
            Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }
            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        f.complete(100);
        f.obtrudeValue(200);
        //f.completeExceptionally(new Exception());
        //System.in.read();
    }

    /**
     * 异常处理的区别
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void test16() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return 100;
        });
        //future.join();
        future.get();
    }
}
