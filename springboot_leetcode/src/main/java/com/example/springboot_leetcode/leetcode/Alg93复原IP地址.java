package com.example.springboot_leetcode.leetcode;

import com.alibaba.fastjson.JSON;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Alg93复原IP地址 {
    // 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    //
    // 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    // 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode.cn/problems/restore-ip-addresses
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // for 选择 in 选择列表:
    //     # 做选择
    //     将该选择从选择列表移除
    //     路径.add(选择)
    //     backtrack(路径, 选择列表)
    //     # 撤销选择
    //     路径.remove(选择)
    //     将该选择再加入选择列表

    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> r = new ArrayList<>();
            if (s.length() <= 4 || s.length() > 12) {
                return r;
            }
            List<String> track = new ArrayList<>();
            work(s, 0, track, r);
            return r;
        }

        public void work(String s, int start, List<String> track, List<String> r) {
            if (track.size() == 4) {
                if (s.length() == start) {
                    r.add(track.stream().collect(Collectors.joining(".")));//加入结果集中
                }
                return;
            }
            for (int l = 1; l <= 3; l++) {//每次1-3个字符
                String sub = null;
                try {
                    sub = s.substring(start, start + l);
                    if ((sub.charAt(0) == '0' && l > 1)) {//开头为0的话，那只能为0了。或者不是255以内。
                        return;
                    }
                    int i = Integer.parseInt(sub);
                    if (i < 0 || i > 255) {
                        return;
                    }
                } catch (Exception e) {
                    return;
                }
                track.add(sub);
                work(s, start + l, track, r);
                track.remove(track.size() - 1);
            }
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            List<String> r = s.restoreIpAddresses("25525511135");
            System.out.println(JSON.toJSONString(r));
        }

    }
}
