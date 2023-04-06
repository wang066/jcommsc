package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Alg46全排列 {
    // https://leetcode-cn.com/problems/permutations/
    // 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    //
    //          
    //
    // 示例 1：
    //
    // 输入：nums = [1,2,3]
    // 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    // 示例 2：
    //
    // 输入：nums = [0,1]
    // 输出：[[0,1],[1,0]]
    // 示例 3：
    //
    // 输入：nums = [1]
    // 输出：[[1]]
    //          
    //
    // 提示：
    //
    //         1 <= nums.length <= 6
    //         -10 <= nums[i] <= 10
    // nums 中的所有整数 互不相同

    static class Solution {
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length == 0) {
                return result;
            }

            Deque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[nums.length];
            dfs(nums, nums.length, 0, path, used, result);
            return result;
        }

        private static void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
            if (length == depth) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < length; i++) {
                if (used[i]) {
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums, nums.length, depth + 1, path, used, result);

                path.removeLast();
                used[i] = false;
            }
        }


        public static void main(String[] args) {
            // Integer i = new Integer(1);
            //
            // List<Integer> list = new ArrayList<>();
            // list.add(i);
            // i = new Integer(2);
            //
            // System.out.println(JSON.toJSONString(list));

            List<List<Integer>> permute = permute(new int[]{1, 2, 3});
            System.out.println(JSON.toJSONString(permute));
        }


    }


}
