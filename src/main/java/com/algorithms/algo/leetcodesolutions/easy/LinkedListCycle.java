package com.algorithms.algo.leetcodesolutions.easy;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l1.next.next.next = l1.next;

        System.out.println(findCycle(l1));
    }

    public static boolean findCycle(ListNode head){
        if(head == null || head.next == null) return false;

        ListNode curr = head;
        int joker = (int) Math.pow(10,6);

        while(curr.next != null){
            curr.val = joker;
            curr = curr.next;
            if(curr.val == joker) return true;
        }

        return false;
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
