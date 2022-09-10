package common;

import java.util.LinkedList;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            // 扫描算式中的运算符
            if (c == '+' || c == '-' || c == '*') {
                // 以运算符为中⼼，分割成两个字符串，分别递归计算
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                // 通过⼦问题的结果，合成原问题的结果
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }

            }

        }
        // 如果 res 为空，说明算式是⼀个数字，没有运算符
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }

    public static void main(String[] args) {
        // expression = "2*3-4*5"
        String expression = "2*3-4*5";
        DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        System.out.println(diffWaysToCompute.diffWaysToCompute(expression));
    }
}
