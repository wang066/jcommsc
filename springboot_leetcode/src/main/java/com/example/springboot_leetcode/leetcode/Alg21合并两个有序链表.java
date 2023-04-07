package com.example.springboot_leetcode.leetcode;

import java.awt.*;

public class Alg21合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode n1 = list1;
            ListNode n2 = list2;
            ListNode f = new ListNode(-1);
            ListNode pre = f;
            while (n1 != null && n2 != null) {
                if (n1.val > n2.val) {
                    pre.next = n2;
                    n2 = n2.next;
                } else {
                    pre.next = n1;
                    n1 = n1.next;
                }
                pre = pre.next;
            }
            pre.next = n1 != null ? n1 : n2;
            return f.next;
        }
    }
}
