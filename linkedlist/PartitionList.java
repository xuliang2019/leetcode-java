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
class Solution {
    public ListNode partition(ListNode head, int x) {
        // use two queues, one to store all the value that less than x,
        // the other to store larger values, then concat the two queues
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            }
            else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        // merge two queues
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}