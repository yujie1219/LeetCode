package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 1; i < n - k + 1; i++) {
            List<Integer> result = new ArrayList<>();
            result.add(i);
            combine(n, k, results, result, i);
        }

        return results;
    }

    private void combine(int n, int k, List<List<Integer>> results, List<Integer> result, int start) {
        int currentLength = result.size();

        for (int i = start + 1; i <= n - (k - currentLength) + 1; i++) {
            result.add(i);
            if (result.size() != k) {
                combine(n, k, results, result, i);
            } else {
                results.add(new ArrayList<>(result));
            }
            result.remove(result.size() - 1);
        }
    }
}
