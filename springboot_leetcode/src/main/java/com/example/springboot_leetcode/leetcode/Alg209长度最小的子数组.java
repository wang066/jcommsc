package com.example.springboot_leetcode.leetcode;

// https://leetcode.cn/problems/minimum-size-subarray-sum/
public class Alg209长度最小的子数组 {

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            int l = 0;
            int minLen = Integer.MAX_VALUE;
            for (int r = 0; r < nums.length; r++) {
                sum += nums[r];
                while (sum >= target) {
                    minLen = Math.min(r - l + 1, minLen);
                    sum = sum - nums[l];
                    l++;
                }
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}
