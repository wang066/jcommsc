package com.example.springboot_leetcode.leetcode;

import java.util.*;

public class Alg94二叉树的中序遍历 {



    class Solution递归 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            mid(root, r);
            return r;
        }

        public void mid(TreeNode n, List<Integer> r) {
            if (n == null) {
                return;
            }
            mid(n.left, r);
            r.add(n.val);
            mid(n.right, r);
        }
    }

    class Solution迭代 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            Deque<TreeNode> q = new LinkedList();
            TreeNode n = root;
            while (n != null || !q.isEmpty()) {
                while (n != null) {
                    q.push(n);
                    n = n.left;
                }
                n = q.pop();
                r.add(n.val);
                n = n.right;
            }

            return r;
        }

    }
}
