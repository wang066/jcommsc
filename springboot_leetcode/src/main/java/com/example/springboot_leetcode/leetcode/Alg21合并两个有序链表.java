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

            ListNode first = new ListNode(-1);
            ListNode p = first;
            while (n1 != null && n2 != null) {
                if (n1.val < n2.val) {
                    p.next = n1;
                    n1 = n1.next;
                } else {
                    p.next = n2;
                    n2 = n2.next;
                }
                p = p.next;
            }
            p.next = n1 != null ? n1 : n2;
            return first.next;
        }
    }
}
