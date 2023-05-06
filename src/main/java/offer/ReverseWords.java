package offer;

import java.util.LinkedList;

public class ReverseWords {

    public String reverseWords(String s) {
        LinkedList<String> list = new LinkedList<>();
        int length = s.length();
        if (length == 0) {
            return "";
        }
        String[] strings = s.split(" ");
        for (String ss : strings) {
            if (ss.trim().length() == 0) {
                continue;
            }
            list.addFirst(ss);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }

    public String reverseWords2(String s) {
        // 双指针
        s = s.trim();
        int length = s.length();
        int start = length - 1, end = length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (start >= 0) {
            while (start >= 0 && s.charAt(start)  != ' ') {
                start--;
            }
            stringBuilder.append(s, start + 1, end + 1);
            stringBuilder.append(" ");
            while (start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            end = start;
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        // the sky is blue -> blue is sky the
        // "  hello world!  " -> "world! hello"
        // "a good   example" -> "example good a"
        String s = "the sky is blue";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
        System.out.println(reverseWords.reverseWords2(s));
        s = "  hello world!  ";
        System.out.println(reverseWords.reverseWords(s));
        System.out.println(reverseWords.reverseWords2(s));
        s = "a good   example";
        System.out.println(reverseWords.reverseWords(s));
        System.out.println(reverseWords.reverseWords2(s));
    }
}
