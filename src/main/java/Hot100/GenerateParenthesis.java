package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }

    class Node {
        private String s;
        private int left;
        private int right;

        public Node(String s, int left, int right) {
            this.s = s;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 广度优先遍历
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left == 0 && node.right == 0) {
                result.add(node.s);
            }
            if (node.left > 0) {
                queue.offer(new Node(node.s + "(", node.left - 1, node.right));
            }
            if (node.right > 0 && node.left < node.right) {
                queue.offer(new Node(node.s + ")", node.left, node.right - 1));
            }
        }
        return result;
    }

    /**
     * 深度优先遍历
     * @param leftLeft
     * @param rightLeft
     * @param curStr
     */
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
        //System.out.println(generateParenthesis.generateParenthesis(n));
        n = 2;
        //System.out.println(generateParenthesis.generateParenthesis(n));
        System.out.println(generateParenthesis.generateParenthesis2(n));
    }
}
