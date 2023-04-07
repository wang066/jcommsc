package com.example.springboot_leetcode.leetcode;

public class Alg121买卖股票的最佳时机 {
    // 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    //
    // 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    //
    // 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    //
    //
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    class Solution暴力 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 1) {
                return 0;
            }
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
            return 0;
        }
    }

    class S一次遍历 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 1) {
                return 0;
            }
            //假设要在当天卖，则求之前的最低点就好了。
            int min = prices[0];
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (min > prices[i]) {
                    min = prices[i];
                }
                max = Math.max(max, prices[i] - min);
            }

            return max;
        }
    }
}
