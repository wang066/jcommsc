package com.example.springboot_leetcode.leetcode;

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

    public static ListNode node(int[] nums) {
        ListNode h = null;
        ListNode pre = null;
        for (int num : nums) {
            ListNode n = new ListNode(num);
            if (h == null) {
                h = n;
            }
            if (pre != null) {
                pre.next = n;
            }
            pre = n;
        }

        return h;
    }

    public static void print(ListNode node) {
        ListNode n = node;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = ListNode.node(new int[]{1, 2, 3, 4, 5});
        print(node);
    }
}
