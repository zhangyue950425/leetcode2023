package ByteDancePractice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146_2 {

    public class DoubleNode {
        private int key;
        private int value;
        private DoubleNode pre;
        private DoubleNode next;

        public DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DoubleNode() {
        }
    }

    private Map<Integer, DoubleNode> map = new HashMap<>();
    private int capacity;
    /**
     * 链表个数
     */
    private int size;
    private DoubleNode head;
    private DoubleNode tail;

    public LRUCache_146_2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DoubleNode();
        this.tail = new DoubleNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 当前key存在，访问一次需要将该值在链表中提到头部
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            // 当前key不存在
            return -1;
        }
    }

    private void moveToHead(DoubleNode doubleNode) {
        // 先删除该节点
        removeNode(doubleNode);
        // 再在head节点后加入一个新节点
        addNodeToHead(doubleNode);
    }

    private void removeNode(DoubleNode doubleNode) {
        doubleNode.pre.next = doubleNode.next;
        doubleNode.next.pre = doubleNode.pre;
    }

    private void addNodeToHead(DoubleNode doubleNode) {
        doubleNode.next = head.next;
        head.next = doubleNode;
        doubleNode.pre = head;
        doubleNode.next.pre = doubleNode;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 该节点存在，更新值并且提到链表头部
            DoubleNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // 该节点不存在，存入并且提到链表头部
            DoubleNode node = new DoubleNode(key, value);
            map.put(key, node);
            addNodeToHead(node);
            this.size++;
            // 存入之前判断容量是否超过capacity,超过从链表尾部删除节点
            if (this.size > this.capacity) {
                DoubleNode tailNode = removeTail();
                map.remove(tailNode.key);
                this.size--;
            }
        }
    }

    private DoubleNode removeTail() {
        DoubleNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache_146_2 lruCache_146_2 = new LRUCache_146_2(2);
        lruCache_146_2.put(1, 1);
        lruCache_146_2.put(2, 2);
        System.out.println(lruCache_146_2.get(1));
        lruCache_146_2.put(3, 3);
        System.out.println(lruCache_146_2.get(2));
        lruCache_146_2.put(4, 4);
        System.out.println(lruCache_146_2.get(1));
        System.out.println(lruCache_146_2.get(3));
        System.out.println(lruCache_146_2.get(4));
    }
}
