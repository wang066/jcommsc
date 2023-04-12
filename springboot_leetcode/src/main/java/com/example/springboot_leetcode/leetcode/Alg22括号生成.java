package com.example.springboot_leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Alg22括号生成 {

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            // 特判
            if (n == 0) {
                return res;
            }

            // 执行深度优先遍历，搜索可能的结果
            dfs(n, n, "", res);
            return res;

            // 作者：liweiwei1419
            // 链接：https://leetcode.cn/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
            // 来源：力扣（LeetCode）
            // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        }

        public void dfs(int l, int r, String s, List<String> res) {
            if (l == 0 && r == 0) {
                res.add(s);
                return;
            }
            if (r < l) {
                return;
            }

            if (l > 0) {
                dfs(l - 1, r, s + "(", res);
            } else {
                dfs(l, r - 1, s + ")", res);
            }
        }
    }
}
