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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int s1 = size(l1);
        int s2 = size(l2);
        int v1 = 0;
        int v2 = 0;
        ListNode resHead = null;
        ListNode curr = null;

        // store the sum in reversing order, dont keep the carry
        while (l1 != null || l2 != null) {
            if (s1 >= s2) {
                v1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                s1--;
            }

            // compare with s1 + 1 since s1 might decrease in previous step
            if (s2 >= s1 + 1) {
                v2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                s2--;
            }

            // append the reverwsed list
            curr = new ListNode(v1 + v2);
            curr.next = resHead;
            resHead = curr;
        }

        // normalize the reversed list
        int carry = 0;
        resHead = null;
        while (curr != null) {
            curr.val += carry;

            if (curr.val >= 10) {
                curr.val = curr.val % 10;
                carry = 1;
            }
            else {
                carry = 0;
            }

            ListNode nextNode = curr.next;
            curr.next = resHead;
            resHead = curr;
            curr = nextNode;
        }

        // check the header since carry may equal to 1
        if (carry == 1) {
            curr = new ListNode(1);
            curr.next = resHead;
            resHead = curr;
        }
        return resHead;

    }

    public int size(ListNode node) {
        int s = 0;
        while (node != null) {
            node = node.next;
            s++;
        }
        return s;
    }
}