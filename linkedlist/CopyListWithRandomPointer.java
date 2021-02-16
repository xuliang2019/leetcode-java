public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // use map
        Map<Node, Node> map = new HashMap<>();
        // copy nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // assign next and random
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
