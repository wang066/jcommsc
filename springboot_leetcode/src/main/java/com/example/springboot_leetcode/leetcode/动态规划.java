package com.example.springboot_leetcode.leetcode;


public class 动态规划 {

    // https://leetcode.cn/problems/longest-palindromic-substring/?favorite=2cktkvj
    static class Solution最长回文字符串 {
        public static String longestPalindrome(String s) {

            if (s == null || s.length() < 1 || s.length() > 1000) {
                return null;
            }

            int len = s.length();
            int maxLen = 1;
            int start = 0;
            boolean[][] dp = new boolean[len][len];

            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }

            for (int L = 2; L <= s.length(); L++) {
                for (int i = 0; i < s.length(); i++) {
                    int j = L - 1 + i;
                    if (j >= s.length()) {
                        break;
                    }

                    if (s.charAt(i) == s.charAt(j)) {
                        if (L == 2) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }

                    if (dp[i][j] && L > maxLen) {
                        maxLen = L;
                        start = i;
                    }
                }
            }

            return s.substring(start, start + maxLen);
        }

        public static void main(String[] args) {
            System.out.println(longestPalindrome("cbbd"));
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
