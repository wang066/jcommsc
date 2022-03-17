package com.example.springboot2.concurrency.c;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author: jowang
 * @date: 2018-09-18 9:43
 * @description:
 */
public class Test2 {


    static long facotialRecusive(long n) {
        return n == 1 ? 1 : n * facotialRecusive(n - 1);
    }

    public void test1() {
        //Optional<Optional<String>> stringOptional=Optional.empty();
        //String s = stringOptional.orElseThrow().get();
        //System.out.println(s);

        //throw null exception
        //Optional<Car> optionalCar = Optional.of(null);

        Optional<Car> optionalCar2 = Optional.ofNullable(null);
        optionalCar2.get();

        Optional<Person> optionalPerson = Optional.empty();
        optionalPerson.get().getAge();
    }

    public void test2() {
        System.out.println(facotialRecusive(3));

        System.out.println(LongStream.rangeClosed(1, 3).reduce(1, (a, b) -> a * b));

        //IntStream.rangeClosed(1,100).
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
        Integer reduce = Stream.iterate(1, i -> i + 1).limit(10).parallel().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    public void test3() {

        //IntStream.rangeClosed(1,100).
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

        IntStream.range(1, 10).forEach(System.out::println);
    }

    public void test4() {
        Stream<String> parallelWords = Stream.of("1", "2", "3").parallel();
        int[] shortWords = new int[12];
    }

    public void test5() throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(() -> {
            System.out.println("start");
        }, 0, 1, TimeUnit.SECONDS);

        service.schedule(() -> {
            System.out.println("only one");
        }, 0, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    public void test10() throws InterruptedException {
        ExecutorService exitingExecutorService = MoreExecutors.getExitingExecutorService(new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy()));

        exitingExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                int i = ThreadLocalRandom.current().nextInt(3, 5);
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(5000);

        System.out.println(exitingExecutorService.isShutdown());
    }

    public void test11() throws Exception {
        //int i = ThreadLocalRandom.current().nextInt(3, 5);
        //System.out.println(i);

        Random random = new Random();
        random.ints(1, 10).limit(10).forEach(t -> System.out.println(t));
        System.out.println("-------");
        System.out.println(random.nextInt(10));
    }

    public void test12() throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(1, new ThreadFactoryBuilder().setDaemon(true).build());
        //threadPool.
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ok");
            }
        });

        TimeUnit.SECONDS.sleep(2);
        System.out.println(threadPool.isTerminated());
        System.out.println(threadPool.isShutdown());
    }

    public static class Car {

    }

    @lombok.Data
    public static class Person {
        private Car car;
        private String name;
        private String age;
    }
}
