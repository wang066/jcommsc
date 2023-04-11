package com.example.springboot_leetcode.leetcode;

public class Alg剑指Offer青蛙跳台阶问题 {
    //  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    //
    // 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    static class Solution {
        public int numWays(int n) {
            if (n == 0) {
                return 0;
            }
            return dp(n);
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.numWays(5));
        }

        public int dp(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            int dp1 = dp(n - 1);
            int dp2 = dp(n - 2);

            return dp1 + dp2;
        }
    }
}
