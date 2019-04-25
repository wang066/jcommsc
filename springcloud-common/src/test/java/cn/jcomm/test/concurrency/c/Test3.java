package cn.jcomm.test.concurrency.c;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import junit.framework.TestCase;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

/**
 * @author: jowang
 * @date: 2018-11-21 11:17
 * @description:
 */
public class Test3 extends TestCase {

    volatile int i = 1;

    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

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
        dist.forEach(System.out :: println);
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
        CompletableFuture.completedFuture(original).thenApply(String :: toUpperCase).thenAcceptBoth(
                CompletableFuture.completedFuture(original).thenApply(String :: toLowerCase),
                (s1, s2) -> result.append(s1 + s2));
        System.out.println(result.toString());
        assertEquals("MESSAGEmessage", result.toString());
    }

    public void test13() throws InterruptedException, ExecutionException {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        CompletableFuture<Void> f = CompletableFuture.allOf(future1, future2);
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
        CompletableFuture<Void> f = future.thenAcceptBoth(CompletableFuture.completedFuture(10), (x, y) -> System.out.println(x * y));
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
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void test16() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });
        //future.join();
        future.get();
    }

    public void test17() {
        ArrayList<String> strings = new ArrayList<>();
        //strings.add("{123:1231}");
        //strings.add("{123:1231}");
        //strings.add("{123:1231}");
        System.out.println(JSON.toJSONString(strings));
        System.out.println(String.format("[%s]", StringUtils.join(strings, ",")));
    }

    public void test18() throws ExecutionException, InterruptedException {
        FutureTask<String> f = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "a";
            }
        });

        f.run();
        System.out.println(f.get());
    }

    public void test19() {
        //ScheduledExecutorService scheduledExecutorService=Executors.unconfigurableScheduledExecutorService()
        //ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    }

    public void test20() {
        Student s1 = new Student();
        s1.setGrade(100);
        Student s2 = new Student();
        s2.setGrade(10);

        s1.compareTo(s2);
    }

    public void test21() {
        System.out.println(DateTime.now().toDate().getTime() - System.currentTimeMillis());
    }

    public void test22() throws InterruptedException {
        //System.out.println(TimeUnit.MICROSECONDS.toNanos(1));

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        DateTime dateTime = DateTime.now().plusSeconds(1);
        int seconds = Seconds.secondsBetween(DateTime.now(), dateTime).getSeconds();
        System.out.println(seconds);
        int seconds2 = Seconds.secondsBetween(DateTime.now(), dateTime.plusDays(1)).getSeconds();
        System.out.println(seconds2);
        scheduledExecutorService.schedule(() -> {
            System.out.println("ok");
            System.out.println(DateTime.now());
        }, seconds, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(5);
    }

    public void test23() throws InterruptedException {
        DelayQueue<Delayed> queue = new DelayQueue<>();
        queue.put(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        });
    }

    public void test24() {

        int number = 10;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >>> 1;
        //右移一位
        printInfo(number);
    }

    public void test25() {
        PriorityQueue<String> pq =
                new PriorityQueue<String>(5, (a, b) -> a.length() - b.length());
        // or pq = new PriorityQueue<String>(5, Comparator.comparing(String::length));
        pq.add("Apple");
        pq.add("PineApple");
        pq.add("Custard Apple");
        while (pq.size() != 0) {
            System.out.println(pq.remove());
        }

    }

    public void test26() {
        ExecutorService exitingExecutorService = MoreExecutors.getExitingExecutorService(new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100)));
    }

    public void test27() {
        int i = ThreadLocalRandom.current().nextInt(10000);
        System.out.println(i);
        try {
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test28() {
        int i = 1 << 3;
        ArrayList<String> strings = Lists.newArrayList("a", "b");
        System.out.println(JSON.toJSONString(strings.stream().filter(t -> t.equals("a")).collect(Collectors.toList())));
    }

    public void test29() {

        //可以插入，但是效率低，没有用comapre
        //HashMap<Student2,Integer> map=new HashMap<>();
        //map.put(new Student2(),1);

        System.out.println(Integer.valueOf(1).equals(null));
        System.out.println(5 % 2);
    }

    public void test30() {
        Integer i = null;
        System.out.println(i == 1);
    }

    public void test31() {
        ArrayList<String> strings = Lists.newArrayList("1", "2");
        List<String> collect = strings.stream().filter(t -> t.equals("1")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    public void test32() {
        ThreadLocal t1 = new ThreadLocal();
        t1.set(1);

        ThreadLocal t2 = new ThreadLocal();
        t2.set(2);

        System.out.println(t1.get() + "" + t2.get());
    }

    public void test33() {
        int i2 = i;
        i2++;
        System.out.println(i2 == i);
    }

    public void test34() {
        Integer i = 1;
        System.out.println(i.equals(null));
    }

    public void test35() {
        ArrayList<String> strings = Lists.newArrayList("1", "2");
        System.out.println(JSON.toJSONString(strings.subList(0, 0)));
    }

    public void test36() {
        System.out.println(Duration.between(LocalDateTime.now(), LocalDate.now().plusDays(1).atStartOfDay()).toHours());
        //51115903
        //50400
    }

    public void test37() {
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(10));// 11
        UnaryOperator<String> ddb = x -> x + 1;
        System.out.println(ddb.apply("aa"));// aa1

    }

    public void test38() {
        Map map = new HashMap();
        String s = "kpname=西峡县华联加油站&kpcode=91411323397444696W&kpaddr=西峡县莲花北路气象站路口&kptel=0377-69698228&kpbank=河南西峡农村商业银行股份有限公司&kpaccount=32585178******&kptelPerson=&merchantTaxnumMake=339901999999510&invoicetype=0&identityCard=&roomNum=";

        String[] split = s.split("&");
        for (String s1 : split) {
            String[] split1 = s1.split("=");
            if (split1.length > 1) {
                map.put(split1[0], split1[1]);
            }
        }

        System.out.println(JSON.toJSONString(map));
    }

    public void test39() {
        System.out.println(JSON.toJSONString(null));
    }

    public void test40() {
        // Create a String with no repeated keys
        Stream<String[]> str = Stream
                .of(new String[][]{{"GFG", "GeeksForGeeks"},
                        {"g", "geeks"},
                        {"G", "Geeks"}});

        // Convert the String to Map
        // using toMap() method
        Map<String, String>
                map = str.collect(
                Collectors.toMap(p -> p[0], p -> p[1]));

        // Print the returned Map
        System.out.println("Map:" + map);
    }

    class Student implements Comparable<Student> {

        private int grade;

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        @Override
        public int compareTo(Student o) {
            return this.grade - o.grade;
        }
    }

    class Student2 {

        private int grade;

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }
    }

}
