package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;

public class Alg42接雨水 {
    // https://leetcode.cn/problems/trapping-rain-water/
    //暴力法
    class Solution {
        public int trap(int[] height) {
            int sum = 0;
            for (int i = 0; i < height.length; i++) {
                if (i == 0 || i == height.length - 1) {
                    continue;
                }

                int lh = height[i], rh = height[i];
                for (int l = i - 1; l >= 0; l--) {
                    if (height[l] > lh) lh = height[l];
                    // else break;后面还可能会有更高的。。
                }
                for (int r = i + 1; r < height.length; r++) {
                    if (height[r] > rh) rh = height[r];
                    // else break;
                }

                int h = Math.min(lh, rh) - height[i];
                if (h > 0)
                    sum += h;
            }

            return sum;
        }

    }

    class Solution双指针 {
        public int trap(int[] height) {
            int size = height.length;
            if (size <= 2) {
                return 0;
            }

            // 记录每个柱子左边柱子最大高度
            int[] maxLeft = new int[size];
            int[] maxRight = new int[size];
            maxLeft[0] = height[0];
            for (int i = 1; i < size; i++) {
                maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
            }
            // 记录每个柱子右边柱子最大高度
            maxRight[size - 1] = height[size - 1];
            for (int i = size - 2; i >= 0; i--) {
                maxRight[i] = Math.max(height[i], maxRight[i + 1]);
            }
            int sum = 0, lmax = 0, rmax = 0;
            for (int i = 0; i < size; i++) {
                int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
                if (count > 0) sum += count;
            }

            return sum;
        }

    }
}
