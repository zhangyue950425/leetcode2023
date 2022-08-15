package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        trace(1, n, k);
        return result;
    }

    private void trace(int start, int n ,int k) {
        if (k == trace.size()) {
            result.add(new LinkedList<>(trace));
            return;
        }
        for (int i = start; i <= n; i++) {
            trace.addLast(i);
            trace(i + 1, n, k);
            trace.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        Combine combine = new Combine();
        System.out.println(combine.combine(n, k));
    }
}
