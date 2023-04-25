package com.example.springboot_leetcode.leetcode;

public class Alg剑指Offer替换空格 {
    // 剑指 Offer 05. 替换空格
    // https://leetcode.cn/problems/ti-huan-kong-ge-lcof/

    class Solution {
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(chars[i]);
                }
            }

            return sb.toString();
        }
    }
}
