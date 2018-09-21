package cn.jcomm.test.concurrency.c;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import junit.framework.TestCase;

/**
 * @author: jowang
 * @date: 2018-09-18 9:43
 * @description:
 */
public class Test2 extends TestCase {
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
        Integer reduce = Stream.iterate(1, i -> i + 1).limit(10).parallel().reduce(0, Integer:: sum);
        System.out.println(reduce);
    }

    public void test3() {

        //IntStream.rangeClosed(1,100).
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

        IntStream.range(1, 10).forEach(System.out:: println);
    }


    public void test4() {
        Stream<String> parallelWords = Stream.of("1", "2", "3").parallel();
        int[] shortWords = new int[12];
    }

    public void test5() throws InterruptedException {
        ScheduledExecutorService service= Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(()->{
            System.out.println("start");
        },0, 1,TimeUnit.SECONDS);

        service.schedule(()->{
            System.out.println("only one");
        },0, TimeUnit.SECONDS);
        Thread.sleep(5000);
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
