package com.example.springboot2.concurrency.a.a1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jowang on 2016/11/18 0018.
 */
public class LinkedListTest {

    A a1, a2, a3;
    A[] as = {a1, a2, a3};

    @Test
    public void test() {
        LinkedList<Integer> link = new LinkedList<Integer>();
        link.add(0, 1);
        link.forEach(i -> System.out.println(i));
        ArrayList<Integer> list = new ArrayList<>();
    }

    //    测试会出现引用异常
    @Test
    public void test2() {
        a1 = new A(1);
        a2 = new A(2);
        a3 = new A(3);

        try {
            for (A a : as) {
                System.out.println(a.i);
            }
        } catch (NullPointerException e) {
            System.out.println("ok");
        }
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        list.forEach(i -> System.out.println(i));
    }

    class A {
        public int i;

        public A(int i) {
            this.i = i;
        }
    }
}

