package com.example.springboot_leetcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Alg102二叉树的层序遍历 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> r = new ArrayList<>();
            if (root == null) {
                return r;
            }
            Deque<TreeNode> q = new LinkedList();
            q.push(root);
            while (!q.isEmpty()) {
                List<Integer> rLevel = new ArrayList<>();
                Deque<TreeNode> qLevel = new LinkedList();
                while (!q.isEmpty()) {
                    TreeNode pop = q.pop();
                    rLevel.add(pop.val);
                    if (pop.left != null) {
                        qLevel.add(pop.left);
                    }
                    if (pop.right != null) {
                        qLevel.add(pop.right);
                    }


                }
                q = qLevel;
                r.add(rLevel);
            }

            return r;
        }

        public static void main(String[] args) {

        }
    }
}
