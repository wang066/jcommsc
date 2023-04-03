package com.example.springboot_leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
public class 无重复字符的最长子串3 {
    public static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            return 0;
        }
    }

    public static class Solution1 {
        public static int lengthOfLongestSubstring(String s) {
            int max = 0;
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                boolean hasEqual = false;
                String temp = "" + chars[i];
                //查找相同的
                for (int j = i + 1; j < chars.length; j++) {
                    if (hasChars(temp, chars[j])) {
                        hasEqual = true;
                        if (max < (j - i)) {
                            max = j - i;
                        }
                        break;
                    } else {
                        temp = temp + chars[j];
                    }
                }
                //没有找到相同的
                if (!hasEqual && max < (chars.length - i)) {
                    max = (chars.length - i);
                }
            }

            return max;
        }

        public static boolean hasChars(String s, char c) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c) {
                    return true;
                }
            }

            return false;
        }

        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
            System.out.println(lengthOfLongestSubstring("abca"));
            System.out.println(lengthOfLongestSubstring("aa"));
            System.out.println(lengthOfLongestSubstring("ab"));
        }
    }

    // 这道题主要用到思路是：滑动窗口
    //
    // 什么是滑动窗口？
    //
    // 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
    //
    // 如何移动？
    //
    // 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
    //
    // 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
    public static class Solution滑动窗口 {
        public static int lengthOfLongestSubstring(String s) {
            int left = 0;
            int max = 0;
            Map<Character, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (indexMap.containsKey(s.charAt(i))) {
                    left = Math.max(left, indexMap.get(s.charAt(i)) + 1);
                }
                indexMap.put(s.charAt(i), i);
                max = Integer.max(max, i - left + 1);
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
        }
    }

}
