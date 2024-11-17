package com.algorithms.algo.solutions.easy;


import java.util.ArrayList;
import java.util.Collections;
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

    //Solution from Geeks For Geeks, I wasn't able to solve it, tried for days
    public static ListNode reverseList(ListNode head) {
        // If we have reached the last node or the linked
        // list is empty, simply return the head of linked
        // list
        if (head == null || head.next == null)
            return head;

        // reverse the rest of linked list and put the first
        // element at the end
        ListNode rest = reverseList(head.next);

        // Make the current head as last node of remaining
        // linked list
        head.next.next = head;

        // Update next of current head to NULL
        head.next = null;

        // Return the reversed linked list
        return rest;
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
