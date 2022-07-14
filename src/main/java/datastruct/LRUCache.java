package datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * 146
 */
public class LRUCache {

    private Map<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    static class Node {
        private Integer k, v;
        private Node prev, next;

        public Node(Integer k, Integer v) {
            this.k = k;
            this.v = v;
        }
    }

    static class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return this.size;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int k, int v) {
        Node node = new Node(k, v);
        cache.addLast(node);
        map.put(k, node);
    }

    private void deleteKey(int k) {
        Node node = map.get(k);
        cache.remove(node);
        map.remove(k);
    }

    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        map.remove(node.k);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        makeRecently(key);
        return node.v;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (this.cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    public static void main(String[] args) {
        // ["LRUCache","put","put","put","put","get","get"]
        // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
