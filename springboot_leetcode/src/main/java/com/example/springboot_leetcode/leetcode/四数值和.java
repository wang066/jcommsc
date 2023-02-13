package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 四数值和 {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2};
        int target = 8;

        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

}