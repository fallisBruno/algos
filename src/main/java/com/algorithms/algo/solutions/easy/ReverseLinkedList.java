package com.algorithms.algo.solutions.easy;


import java.util.List;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode x = reverseList(l1);
        System.out.println(x);

        // Create ListNode l2 = [5, 6, 4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
    }

    public static ListNode reverseList(ListNode head) {
        if(head.next == null) return new ListNode(head.val);
        ListNode node = reverseList(head.next);
        node.next = new ListNode(head.val);
        return node;
    }


    public static class ListNode {
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

}