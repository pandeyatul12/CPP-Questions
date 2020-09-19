package com.kunal.linkedList;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class RearrangeLL {
    public static void reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalfHead = reverse(slow);
        ListNode firstHalfHead = head;

        while (secondHalfHead != null){
            ListNode next = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            secondHalfHead = secondHalfHead.next;
            firstHalfHead.next.next = next;
            firstHalfHead = next;
        }

        if (firstHalfHead != null){
            firstHalfHead.next = null;
        }
    }
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeLL.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}