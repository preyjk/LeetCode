package exercises;

import java.util.List;

/**
 * Question: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * <p>
 * Solution:
 * 1.两遍扫描：第一遍先扫描链表的长度，第二遍扫描容易找到倒数第n个结点
 * 2.一遍扫描：记录两个结点的位置n1 n2，其中n2-n1+1=n+1,此时当后一个结点的next指针为null时，便可以删除前一个结点的next
 */
public class P19_DeleteTailNNode {
    public static void main(String[] args) {
        ListNode p = new ListNode(2, null);
        ListNode head = new ListNode(1, p);
        ListNode res = new P19_DeleteTailNNode().removeNthFromEnd(head, 1);
        System.out.println(head.val);
        System.out.println(head.next);
    }

    /**
     * Definition for singly-linked list.
     */
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

    /**
     * Method 1: 一遍扫描
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int dis = 1;
        while (p2.next != null) {
            p2 = p2.next;
            if (dis < n + 1) {
                dis++;
            } else {
                p1 = p1.next;
            }
        }
        ListNode temp = p1.next;
        // LeetCode报空指针异常，但我本地运行没问题
        p1.next = temp.next;
        temp.next = null;
        return head;
    }

    public ListNode removeNthFromEnd_official(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        for (int i = 0; i < n - 1; i++) {
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
