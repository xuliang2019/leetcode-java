/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {return head;}
        ListNode fast = head;
        ListNode slow = head;

        // get the length of linkedList
        int size = 1; // since head node is the first element in the list
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }

        // simplify rotation times
        int num = k % size;
        // i=1 because slow is already at the first index of this list
        for (int i = 1; i < size - num; i++) {
            slow = slow.next;
        }

        //
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode res = rotateRight(head, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}