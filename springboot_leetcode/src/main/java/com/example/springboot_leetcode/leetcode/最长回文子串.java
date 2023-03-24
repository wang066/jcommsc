package com.example.springboot_leetcode.leetcode;


public class 最长回文子串 {

    static class Solution {
        public static String longestPalindrome(String s) {
            int len = s.length();
            if (s == null || len < 1 || len > 1000) {
                return null;
            }
            int maxLen = 1;
            int start = 0;
            boolean[][] dp = new boolean[len][len];

            for (int i = 0; i < len; i++) {

            }

            return s.substring(start, maxLen);
        }

        public static void main(String[] args) {

        }
    }

    public static class Solution121买卖股票的最佳时机 {
        public int maxProfit(int[] prices) {
            if (prices == null) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int cha = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] - min > cha) {
                    cha = prices[i] - min;
                } else if (min > prices[i]) {
                    min = prices[i];
                }
            }
            return cha;
        }
    }
}
