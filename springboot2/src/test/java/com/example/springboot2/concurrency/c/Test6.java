package com.example.springboot2.concurrency.c;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class Test6 {
    @Test
    void test1() {

    }

    public static class CurringAndPartials {
        static String unCurried(String a, String b) {
            return a + b;
        }

        public static void main(String[] args) {
            Function<String, Function<String, String>> sum = a -> b -> a + b;

            System.out.println(unCurried("a", "b"));

            Function<String, String> hi = sum.apply("hi");
            System.out.println(hi.apply("ho"));

            Function<String, String> sumHi = sum.apply("hup");

            System.out.println(sumHi.apply("Ho"));

            System.out.println(sumHi.apply("hey"));

            TriFunction<Integer, Long, Double, Integer> tf = CurringAndPartials::f;

            tf = (a, b, c) -> 12;
            System.out.println(tf.apply(1,2l,3d));
        }

        static int f(int i, long l, double d) {
            return 99;
        }


        @FunctionalInterface
        public interface TriFunction<T, U, V, R> {
            R apply(T t, U u, V v);
        }
    }


}
