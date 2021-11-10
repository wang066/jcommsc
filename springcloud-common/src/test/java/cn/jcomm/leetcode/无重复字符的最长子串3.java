package cn.jcomm.leetcode;

import java.util.HashMap;
import java.util.Map;
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class 无重复字符的最长子串3 {
    public static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            return 0;
        }
    }

    public static class Solution1 {
        public static int lengthOfLongestSubstring(String s) {
            int max = 0;
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                boolean hasEqual = false;
                String temp = "" + chars[i];
                //查找相同的
                for (int j = i + 1; j < chars.length; j++) {
                    if (hasChars(temp, chars[j])) {
                        hasEqual = true;
                        if (max < (j - i)) {
                            max = j - i;
                        }
                        break;
                    } else {
                        temp = temp + chars[j];
                    }
                }
                //没有找到相同的
                if (!hasEqual && max < (chars.length - i)) {
                    max = (chars.length - i);
                }
            }

            return max;
        }

        public static boolean hasChars(String s, char c) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c) {
                    return true;
                }
            }

            return false;
        }

        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
            System.out.println(lengthOfLongestSubstring("abca"));
            System.out.println(lengthOfLongestSubstring("aa"));
            System.out.println(lengthOfLongestSubstring("ab"));
        }
    }

    //1.kong
    //2.不重复
    //3 重复
    public static class Solution2 {
        public static int lengthOfLongestSubstring(String s) {
            int left = 0;
            int max = 0;
            Map<Character, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (indexMap.containsKey(s.charAt(i))) {
                    left = Math.max(left, indexMap.get(s.charAt(i)) + 1);
                }
                indexMap.put(s.charAt(i), i);
                max = Integer.max(max, i - left + 1);
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
        }
    }
}
