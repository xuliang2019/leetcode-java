class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode first = res;
        ListNode second = res;

        // find the first part nodes
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // find the second part nodes
        while (first != null) {
            first = first.next;
            second = second.next;

        }

        // remove the Nth node (from end)
        second.next = second.next.next;
        return res.next;

    }
}