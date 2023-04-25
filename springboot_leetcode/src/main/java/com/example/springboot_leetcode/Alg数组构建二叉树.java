package com.example.springboot_leetcode;

import com.example.springboot_leetcode.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Alg数组构建二叉树 {

    public TreeNode binaryTree(Integer[] arr) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            TreeNode treeNode = null;
            if (arr[i] != null && arr[i] != -1) {
                treeNode = new TreeNode(arr[i]);
            }
            list.add(treeNode);
            if (i == 0) {
                root = treeNode;
            }
        }

        for (int i = 0; i * 2 + 1 < arr.length; i++) {
            TreeNode node = list.get(i);
            if (node != null) {
                node.left = list.get(i * 2 + 1);
                if (i * 2 + 2 < arr.length)
                    node.right = list.get(i * 2 + 2);
            }
        }

        return root;
    }
}
