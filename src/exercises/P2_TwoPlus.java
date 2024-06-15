package Algorithm;

/**
 * Question:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * Solution:
 * 链表操作题, 思路很直接。细节是链表节点的初始化和创建的位置，这会影响代码的Maintainability.
 */
public class P2_TwoPlus {
    /**
     * Definition for singly-linked list.
     */
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

    /**
     * 时间复杂度: O(max(m,n))
     * 空间复杂度: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**s
     * Low Maintainability Code (need review)
     */
    public ListNode addTwoNumbers_old(ListNode l1, ListNode l2) {
        ListNode top = new ListNode();
        ListNode rear = top;
        int carryNum = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryNum;
            if (sum < 10) {
                rear.val = sum;
                carryNum = 0;
            } else {
                rear.val = sum % 10;
                carryNum = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null) {
                rear.next = new ListNode();
                rear = rear.next;
            }
        }
        while (l1 != null) {
            int sum = l1.val + carryNum;
            if (sum < 10) {
                rear.val = sum;
                carryNum = 0;
            } else {
                rear.val = sum % 10;
                carryNum = 1;
            }
            l1 = l1.next;
            if (l1 != null) {
                rear.next = new ListNode();
                rear = rear.next;
            }
        }
        while (l2 != null) {
            int sum = l2.val + carryNum;
            if (sum < 10) {
                rear.val = sum;
                carryNum = 0;
            } else {
                rear.val = sum % 10;
                carryNum = 1;
            }
            l2 = l2.next;
            if (l2 != null) {
                rear.next = new ListNode();
                rear = rear.next;
            }
        }
        if (carryNum == 1) {
            rear.next = new ListNode();
            rear = rear.next;
            rear.val = 1;
        }
        return top;
    }
}
