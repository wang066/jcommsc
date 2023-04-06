package com.example.springboot_leetcode.leetcode;

import java.util.List;

public class Alg15三数之和 {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return null;
        }

        public int[] sort(int[] nums, int l, int r) {
            if (l < r) {
                int p = p(nums, l, r);
                sort(nums, l, p - 1);
                sort(nums, p + 1, r);
            }

            return nums;
        }

        private int p(int[] nums, int l, int r) {
            int p = nums[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && nums[j] >= p) {
                    j--;
                }
                while (i < j && nums[i] <= p) {
                    i++;
                }
                swap(nums, i, j);
            }

            swap(nums, i, l);
            return i;
        }

        private void swap(int nums[], int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        public static void main(String[] args) {
            int n[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
            Solution s = new Solution();
            s.sort(n, 0, n.length-1);
            System.out.print("快排结果：");
            for (int m : n) {
                System.out.print(m + " ");
            }
        }
    }

}
