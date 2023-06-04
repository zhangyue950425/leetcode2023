package Hot100;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int length = tasks.length;
        char[] chars = new char[26];
        for (char c : tasks) {
            chars[c - 'A']++;
        }
        // 任务数最多任务的数量max
        int max = 0;
        // 任务数量最多的任务个数
        int count = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, chars[i]);
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] == max) {
                count++;
            }
        }
        return Math.max(length, (max - 1) * (n + 1) + count);
    }

    public static void main(String[] args) {
        char[] tasks = new char[] {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        LeastInterval leastInterval = new LeastInterval();
        System.out.println(leastInterval.leastInterval(tasks, n));
    }
}
