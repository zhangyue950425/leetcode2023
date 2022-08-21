package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 记录已经穷举过的密码，防⽌⾛回头路
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String lock = queue.poll();
                if (deads.contains(lock)) {
                    continue;
                }
                if (lock.equals(target)) {
                    return step;
                }
                // 将⼀个节点的未遍历相邻节点加⼊队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(lock, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(lock, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        // 如果穷举完都没找到⽬标密码，那就是找不到了
        return -1;
    }

    /**
     * 将 s[index] 向上拨动⼀次
     * @param s
     * @param index
     * @return
     */
    private String plusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    /**
     * 将 s[index] 向下拨动⼀次
     * @param s
     * @param index
     * @return
     */
    private String minusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // deadends = ["0201","0101","0102","1212","2002"], target = "0202"
        String target = "0202";
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        OpenLock openLock = new OpenLock();
        System.out.println(openLock.openLock(deadends, target));
        target = "0009";
        deadends = new String[]{"8888"};
        System.out.println(openLock.openLock(deadends, target));
        target = "8888";
        deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(openLock.openLock(deadends, target));
    }
}
