import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        // edge case
        if (lists.length == 0) { return null; }
        // use a priority queue to sort ListNode ascending in realtime
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((node1, node2) -> (node1.val - node2.val));
//        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
//            @Override
//            // ascending order
//            public int compare(ListNode node1, ListNode node2) {
//                if (node1.val < node2.val) {
//                    return -1;
//                }
//                else if (node1.val == node2.val) {
//                    return 0;
//                }
//                else {
//                    return 1;
//                }
//            }
//        });

        // append ListNode to pq
        for (ListNode node: lists) {
            // exclude empty ListNode
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode res = new ListNode(0);
        ListNode temp = res;

        // sort and merge ListNode
        while (!pq.isEmpty()) {
            ListNode currNode = pq.poll();
            // points to current min ListNode
            temp.next = currNode;
            // update pointer
            temp = temp.next;

            // append the rest of current Node back to pq
            if (temp.next != null) {
                pq.offer(temp.next);
            }

        }
        return res.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);

        ListNode[] lists = new ListNode[]{node1, node2};
        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}