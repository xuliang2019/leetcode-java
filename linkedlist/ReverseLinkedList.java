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
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            // get next node
            ListNode nextNode = head.next;
            // point current node to res node
            head.next = res;
            // update res node pointer location
            res = head;
            // iterate head node
            head = nextNode;
        }
        return res;

    }
}