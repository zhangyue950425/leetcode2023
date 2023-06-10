package TenDaysByteDancePractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutation {

    /**
     * 回溯(set去重)
     * @param s
     * @return
     */
    /**
     * 保存排列字符串，set自动去重
     */
    Set<String> set = new HashSet<>();
    boolean[] visited;
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        //是否访问标识，因为不能重复访问
        visited = new boolean[chars.length];
        dfs(chars, 0, "");
        String[] result = new String[set.size()];
        int index = 0;
        for (String s1 : set) {
            result[index++] = s1;
        }
        return result;
    }

    /**
     * dfs回溯处理每个排列
     * @param chars 原字符数组
     * @param index 遍历到的索引位置
     * @param s 每次递归拼接的字符串
     */
    private void dfs(char[] chars, int index, String s) {
        // 遍历完一遍字符串放入set中作为一种排序
        if (index == chars.length) {
            set.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(chars, index + 1, s + chars[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        Permutation permutation = new Permutation();
        System.out.println(Arrays.toString(permutation.permutation(s)));
    }
}
