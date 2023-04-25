package com.example.springboot_leetcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/evaluate-reverse-polish-notation/
public class Alg150逆波兰表达式求值 {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> q = new LinkedList();
            // int r = 0;
            for (int i = 0; i < tokens.length; i++) {
                String s = tokens[i];
                if ("+".equals(s)) {
                    int p1 = q.pop();
                    int p2 = q.pop();
                    q.push(p1 + p2);
                } else if ("-".equals(s)) {
                    int p2 = q.pop();
                    int p1 = q.pop();
                    q.push(p1-p2);
                } else if ("*".equals(s)) {
                    int p1 = q.pop();
                    int p2 = q.pop();
                    q.push(p1 * p2);
                } else if ("/".equals(s)) {
                    int p2 = q.pop();
                    int p1 = q.pop();
                    q.push(p1 / p2);
                } else {
                    q.push(Integer.valueOf(s));
                }
            }

            return q.pop();
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int i = s.evalRPN(new String[]{"4", "13", "5", "/", "+"});
            System.out.println(i);
        }
    }
}
