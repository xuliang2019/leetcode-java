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
    public ListNode mergeKLists(ListNode[] lists) {
        // check input
        if (lists.length == 0) { return null;}

        ListNode res = new ListNode(0);
        ListNode curr = res;
        // use a priority queue to store all the list in ascending order
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((node1, node2) -> (node1.val - node2.val));
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // sort listNodes
        while (!pq.isEmpty()) {
            ListNode currNode = pq.poll();
            curr.next = currNode;
            curr = curr.next;
            if (currNode.next != null) {
                pq.offer(currNode.next);
            }
        }
        return res.next;
    }
}