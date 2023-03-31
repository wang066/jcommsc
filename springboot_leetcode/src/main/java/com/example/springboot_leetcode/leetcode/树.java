package com.example.springboot_leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 树 {


    //94. 二叉树的中序遍历 https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
    class Solution {

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

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new ArrayList();
            mid(root, r);
            return r;
        }

        public void mid(TreeNode node, List<Integer> r) {
            if (node != null) {
                mid(node.left, r);
                r.add(node.val);
                mid(node.right, r);
            }
        }
    }
}
