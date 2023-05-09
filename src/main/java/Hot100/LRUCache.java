package Hot100;

import java.util.HashMap;

/**
 * LRU (最近最少使用) 缓存
 */
public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;



    class Node {
        public int key;
        public int val;
        public Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        /**
         * 在链表尾部添加节点 x，时间 O(1)
         * @param node
         */
        public void addLast(Node node) {
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        /**
         * 删除链表中的 x 节点（x 一定存在）
         * 由于是双链表且给的是目标 Node 节点，时间 O(1)
         * @param node
         */
        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        /**
         * 删除链表中第一个节点，并返回该节点，时间 O(1)
         */
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        /**
         * 返回链表长度，时间 O(1)
         * @return
         */
        public int size() {
            return size;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 将某个 key 提升为最近使用的
     * @param key
     */
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    /**
     * 添加最近使用的元素
     * @param key
     */
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    /**
     * 删除某一个 key
     * @param key
     */
    private void deleteKey(int key) {
        Node node = map.get(key);
        if (node != null) {
            cache.remove(node);
        }
        map.remove(key);
    }

    /**
     * 删除最久未使用的元素
     * @return
     */
    private void removeLeastRecently() {
        Node first = cache.removeFirst();
        if (first != null) {
            map.remove(first.key);
        }
    }

    public int get(int key) {
        // O(1)
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        // O(1)
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            makeRecently(key);
        } else {
            int size = cache.size();
            if (size == capacity) {
                removeLeastRecently();
                addRecently(key, value);
            } else {
                addRecently(key, value);
            }

        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));   // 1
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));   // -1
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));   // -1
        System.out.println(lruCache.get(3));   // 3
        System.out.println(lruCache.get(4));   // 4
    }
}
