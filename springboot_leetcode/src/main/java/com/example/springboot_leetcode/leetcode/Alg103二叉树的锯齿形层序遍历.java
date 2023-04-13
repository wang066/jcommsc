package com.example.springboot_leetcode.leetcode;

import java.util.*;

public class Alg103二叉树的锯齿形层序遍历 {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> r = new ArrayList<>();
            if (root == null) {
                return r;
            }
            Deque<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean b = true;
            while (!q.isEmpty()) {
                Deque<TreeNode> qTmp = new LinkedList();
                Deque<Integer> rTmp = new LinkedList<>();
                while (!q.isEmpty()) {
                    TreeNode pop = q.pop();
                    if (pop.left != null) {
                        qTmp.add(pop.left);
                    }
                    if (pop.right != null) {
                        qTmp.add(pop.right);
                    }
                    if(b){
                        rTmp.addLast(pop.val);
                    }else {
                        rTmp.addFirst(pop.val);
                    }

                }
                b = !b;
                q = qTmp;
                r.add(new LinkedList<>(rTmp));
            }

            return r;
        }
    }
}
