package com.example.springboot2.concurrency.a.a1;

/**
 * Created by jowang on 2017/1/3 0003.
 */
public class ListTest {
    /**
     * 多维数组
     */
    public void test1() {
        int[][] magicSquare = {{1}, {2}};
        int[] ints = {1, 2, 3};
        String[] ss = {"1"};
        String[] ss2 = new String[]{"1"};
        for (String s : ss) {
            System.out.println(s);
        }
    }

    /**
     * 多维数组
     */
    public void test() {
        final int NMAX = 10;
        int[][] odds = new int[NMAX][];
        for (int i = 0; i < NMAX; i++) {
            odds[i] = new int[i + 1];
        }


    }

}
