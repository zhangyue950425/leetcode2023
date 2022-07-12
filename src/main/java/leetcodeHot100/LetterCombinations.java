package leetcodeHot100;

import java.util.*;

/**
 * 电话号码的字母组合:
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("abc".split("")));
        map.put("3", Arrays.asList("def".split("")));
        map.put("4", Arrays.asList("ghi".split("")));
        map.put("5", Arrays.asList("jkl".split("")));
        map.put("6", Arrays.asList("mno".split("")));
        map.put("7", Arrays.asList("pqrs".split("")));
        map.put("8", Arrays.asList("tuv".split("")));
        map.put("9", Arrays.asList("wxyz".split("")));
        backtrace(result, digits, 0, map, new StringBuilder());
        return result;
    }

    private void backtrace(List<String> result, String digits, int index, Map<String, List<String>> map, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
        } else {
            char c = digits.charAt(index);
            List<String> nums = map.get(Character.toString(c));
            for (int i = 0; i < nums.size(); i++) {
                stringBuilder.append(nums.get(i));
                backtrace(result, digits, index + 1, map, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations(digits));
    }
}
