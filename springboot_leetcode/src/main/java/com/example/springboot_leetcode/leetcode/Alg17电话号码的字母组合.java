package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Alg17电话号码的字母组合 {
    // 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    //
    // 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    static class Solution {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            List<String> r = new ArrayList<>();
            if (digits == null || digits.isEmpty()) {
                return r;
            }

            List<String> track = new ArrayList<>();
            work(r, track, digits, 0);
            return r;
        }

        public void work(List<String> r, List<String> track, String d, int start) {
            if (d.length() == start) {
                r.add(track.stream().collect(Collectors.joining("")));
                return;
            }
            char c = d.toCharArray()[start];
            String s = phoneMap.get(c);
            char[] charsPhone = s.toCharArray();
            for (int i = 0; i < charsPhone.length; i++) {
                track.add(String.valueOf(charsPhone[i]));
                work(r, track, d, start + 1);
                track.remove(track.size() - 1);
            }
        }

        public static void main(String[] args) {
            String digits = "23";
            System.out.println(JSON.toJSONString(new Solution().letterCombinations(digits)));
            // 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        }
    }
}
