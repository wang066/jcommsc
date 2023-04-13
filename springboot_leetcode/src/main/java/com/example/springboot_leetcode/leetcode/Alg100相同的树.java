package com.example.springboot_leetcode.leetcode;

public class Alg100相同的树 {
    // https://leetcode.cn/problems/same-tree/
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p != null && q != null && p.val == q.val) {
                boolean sl = isSameTree(p.left, q.left);
                if (!sl) {
                    return false;
                }

                boolean sr = isSameTree(p.right, q.right);
                if (!sr) {
                    return false;
                }

                return true;
            }
            return false;
        }
    }
}
