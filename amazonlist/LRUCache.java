import java.util.HashMap;

// store all the inputs in a hashmap<key, Node> and a linkedList, keep them sync
// create a node<key, value> with two pointers(prev, next)
// Always add the new node right after head.
// move node to head after each get or put method
public class LRUCache {
    HashMap<Integer, Node> map;
    Integer capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
            if (map.size() > capacity) {
                Node last = tail.prev;
                map.remove(last.key);
                delete(last);

            }
        }
        else {
            // if exists, update value and move to head
            Node node = map.get(key);
            node.value = value;
            map.put(key, node);
            moveToHead(node);
        }
    }

    public class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node) {
        delete(node);
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */