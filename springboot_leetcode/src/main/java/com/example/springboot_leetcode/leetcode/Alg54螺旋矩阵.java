package com.example.springboot_leetcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Alg54螺旋矩阵 {
    // 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    // https://leetcode.cn/problems/spiral-matrix/

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix.length == 0) {
                return res;
            }
            int l = 0, r =matrix[0].length - 1,  t = 0, b = matrix.length - 1;
            while (true) {
                for (int i = l; i <= r; i++) {
                    res.add(matrix[t][i]);
                }
                t++;
                if (t > b) {
                    break;
                }
                for (int i = t; i <= b; i++) {
                    res.add(matrix[i][r]);
                }
                r--;
                if (l > r) {
                    break;
                }
                for (int i = r; i >= l; i--) {
                    res.add(matrix[b][i]);
                }
                b--;
                if (t > b) {
                    break;
                }
                for (int i = b; i >= t; i--) {
                    res.add(matrix[i][l]);
                }
                l++;
                if (l > r) {
                    break;
                }
            }

            return res;
        }
    }
}
