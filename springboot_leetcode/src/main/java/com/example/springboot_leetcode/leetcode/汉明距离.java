package com.example.springboot_leetcode.leetcode;

public class 汉明距离 {

    static class Solution {
        public static int hammingDistance(int x, int y) {
            int count = 0;
            int i = x ^ y;
            System.out.println("i=" + i);
            int p = 1;
            while (i != 0) {
                if ((i & 1) == 1) {
                    count++;
                }

                i = i >> 1;
                System.out.println(i);
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(hammingDistance(1, 4));
        }
    }
}
