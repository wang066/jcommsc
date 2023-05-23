package com.example.springboot_leetcode.leetcode;

import java.util.Arrays;

// https://leetcode.cn/problems/3sum-closest/
public class Alg44 {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int tempCha = Integer.MAX_VALUE;
            int s = 0;
            Arrays.sort(nums);
            for (int m = 0; m < nums.length; m++) {
                int l = m - 1;
                int r = m + 1;
                while (l >= 0 && r < nums.length) {
                    int sum = nums[l] + nums[m] + nums[r];
                    int cha = sum - target;
                    int absCha = Math.abs(cha);
                    if (cha == 0) {
                        return target;
                    }
                    if (absCha > tempCha) {
                        break;
                    }
                    if (absCha < tempCha) {
                        tempCha = absCha;
                        s = sum;
                    }

                    if (cha > 0) {
                        l--;
                    }
                    if (cha < 0) {
                        r++;
                    }
                }
            }
            return s;
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int i = s.threeSumClosest(new int[]{0,3,97,102,200,300}, 300);
        System.out.println(i);
    }
}
