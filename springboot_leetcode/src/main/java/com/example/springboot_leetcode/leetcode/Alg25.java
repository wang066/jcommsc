package com.example.springboot_leetcode.leetcode;
//   作者：reals
//   链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
//   来源：力扣（LeetCode）
//   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Alg25 {
    public static void main(String[] args) {
        Solution s = new Alg25.Solution();
        ListNode n = s.reverseKGroup(ListNode.node(new int[]{1, 2, 3, 4, 5}), 2);
        ListNode.print(n);
    }

    public static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode d = new ListNode(-1, head);
            ListNode pre = d;
            ListNode end = d;

            while (end.next != null) {
                for (int i = 0; i < k && end != null; i++) end = end.next;
                if (end == null) break;
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
                pre = start;
                end=pre;
            }

            return d.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }


    }
}
