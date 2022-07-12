package learning.Java;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionDemo {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector();
        List<Integer> list = new ArrayList<>();
        Queue queue = new ArrayDeque();
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
    }
}
