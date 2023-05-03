package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber {

    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] factors = new int[]{2, 3, 5};
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        priorityQueue.offer(1L);
        int result = 0;
        for (int i = 0; i < n; i++) {
            Long cur = priorityQueue.poll();
            result = Math.toIntExact(cur);
            for (int factor : factors) {
                if (set.add(factor * cur)) {
                    priorityQueue.offer(factor * cur);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(NthUglyNumber.nthUglyNumber(n));
        n = 1407;
        System.out.println(NthUglyNumber.nthUglyNumber(n));
    }
}
