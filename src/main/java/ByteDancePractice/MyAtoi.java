package ByteDancePractice;

public class MyAtoi {

    public int myAtoi(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        char[] sChars = s.toCharArray();
        // 用来表示符号位，true表示为正数，false表示为负数
        int flag = 1;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (result > Integer.MAX_VALUE / 10) {
                result = Integer.MAX_VALUE;
                break;
            }
            if (result < Integer.MIN_VALUE / 10) {
                result = Integer.MIN_VALUE;
                break;
            }
            char c = sChars[i];
            // 忽略空格
            if (c == ' ') {
                continue;
            }
            // 符号位判断
            if (c == '+') {
                flag = 1;
                continue;
            }
            if (c == '-') {
                flag = -1;
                continue;
            }
            // 非数字
            if (!(c >= '0' && c <= '9')) {
                break;
            }
            int num = c - '0';
            result = result * 10 + flag * num;
        }
        return result;
    }

    public int myAtoi2(String s) {
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        int result = 0;
        if (length == 0) {
            return 0;
        }
        // 先去掉前导空格
        int index = 0;
        while (index < length && sChars[index] == ' ') {
            index++;
        }
        // 都收空格
        if (length == index) {
            return result;
        }
        // 获取符号位
        int sign = 1;
        if (sChars[index] == '+') {
            sign = 1;
            index++;
        } else if (sChars[index] == '-'){
            sign = -1;
            index++;
        }
        // 循环判断
        while (index < length) {
            char c = sChars[index++];
            if (!(c >= '0' && c <= '9')) {
                break;
            }
            // 溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10)) {
                result = Integer.MAX_VALUE;
                break;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && c - '0' > - (Integer.MIN_VALUE % 10))) {
                result = Integer.MIN_VALUE;
                break;
            }
            // 计算
            int num = c - '0';
            result = result * 10 + sign * num;
        }
        return result;
    }

    public static void main(String[] args) {
        // 输入：s = "42"
        // 输出：42
        // 输入：s = "   -42"
        // 输出：-42
        // 输入：s = "4193 with words"
        // 输出：4193
        MyAtoi myAtoi = new MyAtoi();
        String s = "42";
        //System.out.println(myAtoi.myAtoi(s));
        //System.out.println(myAtoi.myAtoi2(s));
        s = "   -42";
        //System.out.println(myAtoi.myAtoi(s));
        //System.out.println(myAtoi.myAtoi2(s));
        s = "4193 with words";
        //System.out.println(myAtoi.myAtoi(s));
        //System.out.println(myAtoi.myAtoi2(s));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println((Integer.MIN_VALUE % 10));
        /*System.out.println(- Math.pow(2, 31));

        System.out.println(Math.pow(2, 31) - 1);*/
        s = "-91283472332";
        //System.out.println(myAtoi.myAtoi(s));
        //System.out.println(myAtoi.myAtoi2(s));
        s = "+-12";
        //System.out.println(myAtoi.myAtoi(s));
        //System.out.println(myAtoi.myAtoi2(s));
        s = "2147483648";
        System.out.println(myAtoi.myAtoi2(s));
        s = "2147483658";
        System.out.println(myAtoi.myAtoi2(s));


    }
}
