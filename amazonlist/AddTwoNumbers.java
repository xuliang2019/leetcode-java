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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode current = res;
        int sum = 0;

        while (l1 != null || l2 != null) {
            // reset sum after every iteration
            // when sum >= 10, add 1 to the next digit
            sum /= 10;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;

        }

        // for the sum of last digit equals to 10
        if (sum / 10 == 1) {
            current.next = new ListNode(1);
        }
        return res.next;

    }
}