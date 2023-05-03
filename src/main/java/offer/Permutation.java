package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutation {
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (hashSet.contains(c[i])) continue;
            hashSet.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(Arrays.toString(permutation.permutation("abc")));
    }
}
