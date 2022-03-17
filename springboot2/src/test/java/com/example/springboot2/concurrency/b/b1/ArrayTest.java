package com.example.springboot2.concurrency.b.b1;

import java.util.Arrays;

/**
 * Created by jowang on 2017/4/24 0024.
 */
public class ArrayTest {

    /**
     * 循环填充数据
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] ss = new String[10];
        Arrays.fill(ss, "?");
        Arrays.stream(ss).forEach(t -> System.out.println(t));
    }

    /**
     * string format
     *
     * @throws Exception
     */
    public void test1() throws Exception {
        System.out.println(String.format("%%%s%%", "123"));
    }
}
