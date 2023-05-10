package Hot100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }

    private void dfs(int leftLeft, int rightLeft, String curStr) {
        if (leftLeft == 0 && rightLeft == 0) {
            result.add(curStr);
            return;
        }
        if (leftLeft > rightLeft) {
            return;
        }
        if (leftLeft > 0) {
            dfs(leftLeft - 1, rightLeft, curStr + "(");
        }
        if (rightLeft > 0) {
            dfs(leftLeft, rightLeft - 1, curStr + ")");
        }

    }

    public static void main(String[] args) {
        // ["((()))","(()())","(())()","()(())","()()()"]
        int n = 3;
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(n));
    }
}
