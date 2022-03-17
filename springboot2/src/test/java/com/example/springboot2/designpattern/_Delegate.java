package com.example.springboot2.designpattern;

import java.lang.reflect.Method;

/**
 * @author: jowang
 * @date: 2018-06-30 10:53
 * @description:
 */
public class _Delegate {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("cn.jcomm.test.designpattern.A");
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        for (int i = 0; i < 16; i++) {
            m.invoke(o, Integer.toString(i));
        }

    }
}
class A {
    public void foo(String name) {
        System.out.println("Hello, " + name);
    }
}