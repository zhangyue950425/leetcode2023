package string;

/**
 * Offer.67
 */
public class StrToInt {
    public int strToInt(String str) {
        int length = str.length();
        char[] chars = str.toCharArray();
        int index = 0;
        while (index < length && chars[index] == ' ') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        int sign = 1;
        char firstChar = chars[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -sign;
        }
        int res = 0;
        while (index < length) {
            char currentChar = chars[index];
            if (currentChar < '0' || currentChar > '9') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10
                            && (currentChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10 &&
                            (currentChar - '0') > - (Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (currentChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "42";
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.strToInt(s));
        s = "   -42";
        System.out.println(strToInt.strToInt(s));
        s = "4193 with words";
        System.out.println(strToInt.strToInt(s));
        s = "words and 987";
        System.out.println(strToInt.strToInt(s));
        s = "-91283472332";
        System.out.println(strToInt.strToInt(s));

    }
}
