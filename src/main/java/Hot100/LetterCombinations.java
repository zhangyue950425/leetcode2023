package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return result;
        }
        backtrace(0, digits, new StringBuilder());
        return result;
    }

    private void backtrace(int index, String digits, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
        } else {
            char ch = digits.charAt(index);
            String s = map.get(ch);
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                backtrace(index + 1, digits, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        // 输入：digits = "23"
        // 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        String digits = "23";
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations(digits));
    }
}
