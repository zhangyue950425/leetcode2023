package leetcodeHot100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {


    public List<String> generateParenthesis(int n) {
        List<String> reuslt = new ArrayList<>();
        int leftCount = n, rightCount = n;
        backtrace(leftCount, rightCount, new StringBuilder(), reuslt);
        return reuslt;
    }

    private void backtrace(int leftCount, int rightCount, StringBuilder stringBuilder, List<String> reuslt) {
        if (leftCount == 0 && rightCount == 0) {
            reuslt.add(stringBuilder.toString());
            return;
        }
        if (leftCount > rightCount) {
            return;
        }
        if (leftCount > 0) {
            stringBuilder.append("(");
            backtrace(leftCount - 1, rightCount, stringBuilder, reuslt);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (rightCount > 0) {
            stringBuilder.append(")");
            backtrace(leftCount, rightCount - 1, stringBuilder, reuslt);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis_22 generateParenthesis22 = new GenerateParenthesis_22();
        int n = 3;
        System.out.println(generateParenthesis22.generateParenthesis(n));
        n = 1;
        System.out.println(generateParenthesis22.generateParenthesis(n));
    }


}
