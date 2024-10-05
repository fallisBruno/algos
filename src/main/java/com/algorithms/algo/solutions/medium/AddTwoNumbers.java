package com.algorithms.algo.solutions.medium;

public class AddTwoNumbers {

    public static void main(String[] args) {
        // Create ListNode l1 = [2, 4, 3]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create ListNode l2 = [5, 6, 4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        add(l1, l2);
        //add(new ListNode(0), new ListNode(0));
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        addRecursive(l1, l2, result, 0);
        return result;
    }

    //I'm really proud of my solution below :)
    private static void addRecursive(ListNode l1, ListNode l2, ListNode listNode, int rest) {
        int currentL1 = l1 == null ? 0 : l1.val;
        int currentL2 = l2 == null ? 0 : l2.val;
        int sum = currentL1 + currentL2 + rest;
        if (sum > 9) {
            listNode.val = sum % 10;
            rest = 1;
        } else {
            listNode.val = sum;
            rest = 0;
        }

        if ((l1 == null || l1.next == null) && (l2 == null || l2.next == null) && rest == 0)
            return;

        ListNode next = new ListNode();
        listNode.next = next;

        addRecursive(l1 == null ? null : l1.next, l2 == null ? null : l2.next, next, rest);
    }

    //while loop solution that asked ChatGPT to implement (even that I knew how to implement it) based
    //on the recursive solution above. I thought that the while loop one could be faster and use less memory,
    //but it's not
    public static ListNode addI(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();  // Initialize the result node
        ListNode current = result;         // Pointer to traverse the result list
        int rest = 0;                      // Variable to store carry-over value

        while (l1 != null || l2 != null || rest != 0) {
            int currentL1 = (l1 != null) ? l1.val : 0;  // Get value from l1 or 0 if null
            int currentL2 = (l2 != null) ? l2.val : 0;  // Get value from l2 or 0 if null
            int sum = currentL1 + currentL2 + rest;     // Sum the values and carry

            if (sum > 9) {
                current.val = sum % 10;  // Store the last digit
                rest = 1;                // Carry over 1
            } else {
                current.val = sum;       // Store the sum if no carry
                rest = 0;
            }

            // Move l1 and l2 pointers to the next nodes
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

            // Only create a next node if there are more nodes to process or rest is not 0
            if (l1 != null || l2 != null || rest != 0) {
                current.next = new ListNode();  // Prepare next node in result list
                current = current.next;         // Move the pointer to the next node
            }
        }

        return result;
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
