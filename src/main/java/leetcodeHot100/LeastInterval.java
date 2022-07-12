package leetcodeHot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 621. 任务调度器
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        // 标记任务是否被用过
        boolean[] used = new boolean[tasks.length];
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : tasks) {
            map.put(c, 0);
        }
        for (int i = 0; i < tasks.length; i++) {
            if (used[i]) {
                continue;
            } else {
                Integer count = map.get(tasks[i]);
                if (list.contains(tasks[i]) && count < n) {
                    continue;
                } else {
                    list.add(tasks[i]);
                }
            }
        }
        return 0;
    }

}
