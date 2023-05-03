package offer;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null;
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node = new Node(13);
        head.next = node;
        head.random = null;
        Node node1 = new Node(11);
        node.next = node1;
        node.random = head;
        Node node2 = new Node(10);
        node1.next = node2;
        Node node3 = new Node(1);
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.next = null;
        node3.random = head;
        copyRandomList(head);
        copyRandomList2(head);
    }
}
