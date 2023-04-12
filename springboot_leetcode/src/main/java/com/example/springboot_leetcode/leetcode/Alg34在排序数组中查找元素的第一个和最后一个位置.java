package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;

public class Alg34在排序数组中查找元素的第一个和最后一个位置 {
    //     给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    //
    // 如果数组中不存在目标值 target，返回 [-1, -1]。
    //
    // 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // https://www.zhihu.com/question/36132386

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};

            int l = 0, r = nums.length - 1; //二分范围
            while (l < r)                    //查找元素的开始位置
            {
                int mid = (l + r) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (nums[r] != target) return new int[]{-1, -1}; //查找失败
            int L = r;
            l = 0;
            r = nums.length - 1;     //二分范围
            while (l < r)                    //查找元素的结束位置
            {
                int mid = (l + r + 1) / 2;
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            return new int[]{L, r};

            // 作者：lin-shen-shi-jian-lu-k
            // 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/tu-jie-er-fen-zui-qing-xi-yi-dong-de-jia-ddvc/
            // 来源：力扣（LeetCode）
            // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        }

        public static int bs(int[] nums, int l, int r, int v) {
            int mid;
            while (l < r) {
                mid = (l + r) / 2;
                if (nums[mid] < v) l = mid + 1;
                else r = mid;
            }

            return r;
        }


        public static void main(String[] args) {
            int[] nums = {1, 4};
            int target = 3;
            System.out.println(bs(nums, 0, nums.length, target));

            Solution s = new Solution();
            int[] r = s.searchRange(nums, target);
            System.out.println(JSON.toJSONString(r));
        }
    }
}
