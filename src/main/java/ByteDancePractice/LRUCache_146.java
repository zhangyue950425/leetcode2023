package ByteDancePractice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

    /**
     * 双向链表的节点类
     */
    public static class DLinkedNode {

        private Integer key;

        private Integer value;
        private DLinkedNode prev;
        private DLinkedNode next;

        public DLinkedNode(Integer key, Integer value) {
            this.value = value;
            this.key = key;
        }

        public DLinkedNode() {
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * cache 中没有key对应值的话直接返回-1，存在的话返回对应的值，
     * 并且需要将该值提到双向链表的头部，表示最近访问的元素
     * @param key
     * @return
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            // 将node节点提到head节点之后，相当于删除该节点并在head后增加一个节点
            DLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    /**
     * 将key-value对放入map中，如果原本不存在的话直接放入map中，并且需要将该节点加到head节点之后
     * 如果map中已存在的话，更新值，需要将该节点移动到head节点后
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key, node);
            addNodeToHead(node);
            size++;
            if (size > capacity) {
                // 淘汰最近最久未访问的节点，即tail前的那个节点,同时map中数据也要删除
                // 所以需要节点中保存key,通过删除节点返回该节点的key
                DLinkedNode node1 = removeTail();
                cache.remove(node1.key);
                size--;
            }
        } else {
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache_146 lruCache146 = new LRUCache_146(2);
        lruCache146.put(1, 1);
        lruCache146.put(2, 2);
        System.out.println(lruCache146.get(1));
        lruCache146.put(3, 3);
        System.out.println(lruCache146.get(2));
        lruCache146.put(4, 4);
        System.out.println(lruCache146.get(1));
        System.out.println(lruCache146.get(3));
        System.out.println(lruCache146.get(4));
    }
}
