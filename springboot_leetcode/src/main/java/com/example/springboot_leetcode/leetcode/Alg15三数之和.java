package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alg15三数之和 {

    // 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
    //
    // 你返回所有和为 0 且不重复的三元组。
    //
    // 注意：答案中不可以包含重复的三元组。
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode.cn/problems/3sum
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    static class Solution {
        public static void main(String[] args) {
            int[] nums = {-1, 0, 1, 2, -1, -4};
            Solution s = new Solution();
            List<List<Integer>> l = s.threeSum(nums);
            System.out.println(JSON.toJSONString(l));
        }

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return list;
            }
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int l = i + 1;
                int r = len - 1;
                if (nums[i] > 0) {
                    return list;
                }
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == 0) {
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                        l++;
                        continue;
                    }
                    if (nums[i] + nums[l] + nums[r] > 0) {
                        r--;
                        continue;
                    }
                    if (nums[i] + nums[l] + nums[r] < 0) {
                        l++;
                        continue;
                    }
                }
            }

            return list;
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

        // public static void main(String[] args) {
        //     int n[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        //     Solution s = new Solution();
        //     s.sort(n, 0, n.length - 1);
        //     System.out.print("快排结果：");
        //     for (int m : n) {
        //         System.out.print(m + " ");
        //     }
        // }
    }

}
