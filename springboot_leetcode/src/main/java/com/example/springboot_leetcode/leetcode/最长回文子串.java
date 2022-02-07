package com.example.springboot_leetcode.leetcode;

import org.apache.commons.collections.map.LinkedMap;

public class 最长回文子串 {

    static class Solution {
        public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1 || s.length() > 1000) {
                return null;
            }
            int maxLen = 1;
            String maxStr = "";

            for (int i = 0; i < s.length(); i++) {

                // char c = s.charAt(i);
                // int offset = 0;
                // int left = i - offset;
                // int right = i + offset
                // while (s.charAt(i - 1) == s.charAt(right)) {
                //     offset
                //     left > 0 && right < s.length() && s.charAt(i - 1) == s.charAt(right)
                //     maxLen =
                // }
            }

            return maxStr;
        }

        public static void main(String[] args) {

        }
    }
}
