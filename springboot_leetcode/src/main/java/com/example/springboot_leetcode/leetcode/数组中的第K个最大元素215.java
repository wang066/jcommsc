package com.example.springboot_leetcode.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
public class 数组中的第K个最大元素215 {

    static class Solution {
        public static void main(String[] args) {
            int[] nums = new int[]{3, 2, 1, 5, 6, 4};
            findKthLargest(nums,2);

            System.out.println(Arrays.toString(nums));
        }

        public static int findKthLargest(int[] nums, int k) {
            quicksort(nums, 0, nums.length - 1);
            return 0;
        }

        public static void quicksort(int[] nums, int low, int high) {
            if (low < high) {
                int p = partition(nums, low, high);
                quicksort(nums, low, p - 1);
                quicksort(nums, p + 1, high);
            }
        }

        private static void swap(int n[], int i, int j) {
            int temp = n[i];
            n[i] = n[j];
            n[j] = temp;
            System.out.println(Arrays.toString(n));
        }

        public static int partition(int[] nums, int low, int high) {
            int p = nums[high];
            int i = low;
            int j = high;
            while (i < j) {
                while (nums[i] < p && i < j) {
                    i++;
                }
                while (nums[j] > p && i < j) {
                    j--;
                }
                if (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

            nums[high] = nums[i];
            nums[i] = p;

            return i;
        }

    }

}
