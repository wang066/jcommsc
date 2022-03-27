package com.example.springboot_leetcode.leetcode;

// https://leetcode-cn.com/problems/longest-increasing-subsequence/
public class 最长递增子序列300 {

    static class Solution {
        public static int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }


            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                int num = 1;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > temp) {
                        num++;
                        temp = nums[j];
                    }
                }

                if (num > max) {
                    max = num;
                }

            }

            return max;
        }

        public static int lengthOfLIS动态规划(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }

        public static void main(String[] args) {
            System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
            System.out.println(lengthOfLIS动态规划(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        }
    }

}
