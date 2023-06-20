package ByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public String convert(String s, int numRows) {
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int index = 0;
        int flag = -1;
        for (int i = 0; i < length; i++) {
            StringBuilder stringBuilder = list.get(index);
            stringBuilder.append(sChars[i]);
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            index = index + flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        /**
         * 输入：s = "PAYPALISHIRING", numRows = 4
         * 输出："PINALSIGYAHRPI"
         * 解释：
         * P     I    N
         * A   L S  I G
         * Y A   H R
         * P     I
         */
        Convert convert = new Convert();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String result = convert.convert(s, numRows);
        System.out.println(result);
        System.out.println("PINALSIGYAHRPI".equals(result));
    }
}
