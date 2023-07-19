package ByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }

    private void dfs(int leftLeft, int rightLeft, String cur) {
        if (leftLeft == 0 && rightLeft == 0) {
            result.add(cur);
            return;
        }
        if (leftLeft > rightLeft) {
            return;
        }
        if (leftLeft > 0) {
            dfs(leftLeft - 1, rightLeft, cur + "(");
        }
        if (rightLeft > 0) {
            dfs(leftLeft, rightLeft - 1, cur + ")");
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        StringBuilder stringBuilder = new StringBuilder();
        backtrace(stringBuilder, n, n, result);
        return result;
    }

    public List<String> generateParenthesis3(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        StringBuilder stringBuilder = new StringBuilder();
        backtrace2(stringBuilder, n, n, result);
        return result;
    }

    private void backtrace2(StringBuilder stringBuilder, int leftLeft, int rightLeft, List<String> result) {
        if (leftLeft == 0 && rightLeft == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        if (leftLeft < 0 || rightLeft < 0) {
            return;
        }
        if (leftLeft > rightLeft) {
            return;
        }
        stringBuilder.append("(");
        backtrace2(stringBuilder, leftLeft - 1, rightLeft, result);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");
        backtrace2(stringBuilder, leftLeft, rightLeft - 1, result);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    private void backtrace(StringBuilder stringBuilder, int leftLeft, int rightLeft, List<String> result) {
        if (leftLeft == 0 && rightLeft == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        if (leftLeft > rightLeft) {
            return;
        }
        if (leftLeft > 0) {
            stringBuilder.append("(");
            backtrace(stringBuilder, leftLeft - 1, rightLeft, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (rightLeft > 0) {
            stringBuilder.append(")");
            backtrace(stringBuilder, leftLeft, rightLeft - 1, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis_22 generateParenthesis22 = new GenerateParenthesis_22();
        int n = 3;
        System.out.println(generateParenthesis22.generateParenthesis(n));
        System.out.println(generateParenthesis22.generateParenthesis2(n));
        System.out.println(generateParenthesis22.generateParenthesis3(n));
        n = 1;
        System.out.println(generateParenthesis22.generateParenthesis(n));
        System.out.println(generateParenthesis22.generateParenthesis2(n));
        System.out.println(generateParenthesis22.generateParenthesis3(n));

    }
}
