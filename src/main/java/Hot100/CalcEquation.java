package Hot100;

import java.util.*;

public class CalcEquation {

    class Pair {
        int index;
        double value;

        public Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }
        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = - 1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0));
                int ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;
                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equations1 = new ArrayList<>();
        equations1.add("a");
        equations1.add("b");
        equations.add(equations1);
        equations1 = new ArrayList<>();
        equations1.add("b");
        equations1.add("c");
        equations.add(equations1);
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> queries1 = new ArrayList<>();
        queries1.add("a");
        queries1.add("c");
        queries.add(queries1);
        queries1 = new ArrayList<>();
        queries1.add("b");
        queries1.add("a");
        queries.add(queries1);
        queries1 = new ArrayList<>();
        queries1.add("a");
        queries1.add("e");
        queries.add(queries1);
        queries1 = new ArrayList<>();
        queries1.add("a");
        queries1.add("a");
        queries.add(queries1);
        queries1 = new ArrayList<>();
        queries1.add("x");
        queries1.add("x");
        queries.add(queries1);
        CalcEquation calcEquation = new CalcEquation();
        System.out.println(Arrays.toString(calcEquation.calcEquation(equations, values, queries)));
    }
}
