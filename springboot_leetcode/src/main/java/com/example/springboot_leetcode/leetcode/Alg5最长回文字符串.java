package com.example.springboot_leetcode.leetcode;


public class Alg5最长回文字符串 {

    // https://leetcode.cn/problems/longest-palindromic-substring/?favorite=2cktkvj
    // 动态规划
    static class Solution {
        // public static String longestPalindrome(String s) {
        //
        //     if (s == null || s.length() < 1 || s.length() > 1000) {
        //         return null;
        //     }
        //
        //     int len = s.length();
        //     int maxLen = 1;
        //     int start = 0;
        //     boolean[][] dp = new boolean[len][len];
        //
        //     for (int i = 0; i < s.length(); i++) {
        //         dp[i][i] = true;
        //     }
        //
        //     for (int L = 2; L <= s.length(); L++) {
        //         for (int i = 0; i < s.length(); i++) {
        //             int j = L - 1 + i;
        //             if (j >= s.length()) {
        //                 break;
        //             }
        //
        //             if (s.charAt(i) == s.charAt(j)) {
        //                 if (L == 2) {
        //                     dp[i][j] = true;
        //                 } else {
        //                     dp[i][j] = dp[i + 1][j - 1];
        //                 }
        //             } else {
        //                 dp[i][j] = false;
        //             }
        //
        //             if (dp[i][j] && L > maxLen) {
        //                 maxLen = L;
        //                 start = i;
        //             }
        //         }
        //     }
        //
        //     return s.substring(start, start + maxLen);
        // }

        public static void main(String[] args) {
            System.out.println(longestPalindrome("bb"));
        }

        public static String longestPalindrome(String s) {

            char[] chars = s.toCharArray();
            boolean[][] dp = new boolean[chars.length][chars.length];
            for (int i = 0; i < chars.length; i++) {
                dp[i][i] = true;
            }

            int maxLen = 1;
            int start = 0;
            for (int Len = 2; Len <= chars.length; Len++) {
                for (int l = 0; l < chars.length; l++) {
                    //边界情况
                    int r = l + Len - 1;
                    if (r >= chars.length) {
                        break;
                    }
                    if (chars[l] == chars[r]) {
                        if (Len == 2) {
                            dp[l][r] = true;
                        } else {
                            dp[l][r] = dp[l + 1][r - 1];
                        }
                    }

                    if (dp[l][r] && Len > maxLen) {
                        maxLen = Len;
                        start = l;
                    }
                }
            }

            return s.substring(start, start + maxLen);
        }
    }

}
