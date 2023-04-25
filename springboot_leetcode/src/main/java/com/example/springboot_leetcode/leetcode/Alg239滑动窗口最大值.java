package com.example.springboot_leetcode.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Alg239滑动窗口最大值 {
    // https://leetcode.cn/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/

    //不会
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1 != o2 ? o2[0] - o1[0] : o2[1] - o1[1];
                }
            });

            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; i++) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }

            return ans;
        }
    }

    // https://leetcode.cn/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
}
