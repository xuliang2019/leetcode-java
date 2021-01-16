 public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;

        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;

            if (v1 <= v2) {
                ListNode node = new ListNode(v1);
                curr.next = node;
                curr = curr.next;
                l1 = l1.next;
            }
            else {
                ListNode node = new ListNode(v2);
                curr.next = node;
                curr = curr.next;
                l2 = l2.next;
            }

        }

        curr.next = l1 == null ? l2 : l1;

//         while (l1 != null) {
//             ListNode node = new ListNode(l1.val);
//             curr.next = node;
//             curr = curr.next;
//             l1 = l1.next;
//         }

//         while (l2 != null) {
//             ListNode node = new ListNode(l2.val);
//             curr.next = node;
//             curr = curr.next;
//             l2 = l2.next;
//         }
        return res.next;
    }
}