package TenDaysByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    /**
     * 贪心算法
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        int[] lastIndex = new int[26];
        char[] sChars = s.toCharArray();
        // 记录每个字符出现的最后一个位置的索引值
        for (int i = 0; i < length; i++) {
            lastIndex[sChars[i] - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, lastIndex[sChars[i] - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels(s));
    }
}
