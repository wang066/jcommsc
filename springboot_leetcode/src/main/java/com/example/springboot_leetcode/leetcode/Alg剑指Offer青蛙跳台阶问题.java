package com.example.springboot_leetcode.leetcode;

public class Alg剑指Offer青蛙跳台阶问题 {
    //  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    //
    // 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //递归
    static class Solution {

    }

    static class Solution动态规划 {
        public int numWays(int n) {
            int[] dp = new int[Math.max(3,n + 1)];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n]% 1000000007;
        }
    }
}
