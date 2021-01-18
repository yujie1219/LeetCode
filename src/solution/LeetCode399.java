package solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int[] used = new int[equations.size()];
        Map<Foo, Double> allValues = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            if (used[i] != 1) {
                restoreValue(used, values, equations, allValues, i);
            }
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Foo current = new Foo(queries.get(i).get(0), queries.get(i).get(1));
            result[i] = allValues.containsKey(current) ? allValues.get(current) : -1.00000;
        }

        return result;
    }

    private void restoreValue(int[] used, double[] values, List<List<String>> equations, Map<Foo, Double> allValues, int curentIndex) {
        if (used[curentIndex] != 1) {
            String a = equations.get(curentIndex).get(0);
            String b = equations.get(curentIndex).get(1);
            Foo foo1 = new Foo(a, b);
            Double value1 = values[curentIndex];
            Foo foo2 = new Foo(b, a);
            Double value2 = 1 / value1;

            allValues.put(foo1, value1);
            allValues.put(foo2, value2);
            allValues.put(new Foo(a, a), 1.00000);
            allValues.put(new Foo(b, b), 1.00000);
            used[curentIndex] = 1;

            for (int i = curentIndex + 1; i < equations.size(); i++) {
                if (equations.get(i).get(0).equals(a)) {
                    Foo foo3 = new Foo(b, equations.get(i).get(1));
                    Double value3 = value2 * values[i];
                    allValues.put(foo3, value3);
                    restoreValue(used, values, equations, allValues, i);
                } else if (equations.get(i).get(0).equals(b)) {
                    Foo foo3 = new Foo(a, equations.get(i).get(1));
                    Double value3 = value1 * values[i];
                    allValues.put(foo3, value3);
                    restoreValue(used, values, equations, allValues, i);
                } else if (equations.get(i).get(1).equals(a)) {
                    Foo foo3 = new Foo(equations.get(i).get(0), b);
                    Double value3 = value1 * values[i];
                    allValues.put(foo3, value3);
                    restoreValue(used, values, equations, allValues, i);
                } else if (equations.get(i).get(1).equals(b)) {
                    Foo foo3 = new Foo(a, equations.get(i).get(0));
                    Double value3 = value2 * values[i];
                    allValues.put(foo3, value3);
                    restoreValue(used, values, equations, allValues, i);
                }
            }
        }
    }

    public class Foo {
        public String a;
        public String b;

        public Foo(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Foo foo = (Foo) o;
            return a.equals(foo.a) &&
                    b.equals(foo.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
