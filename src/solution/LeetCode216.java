package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(n, k, 1, new ArrayList<>());
        return this.result;
    }

    private void combinationSum3(int k, int n, int current, List<Integer> res) {
        if (n == 0 && k == 0) {
            this.result.add(new ArrayList<>(res));
        } else if (n == 0 || k == 0 || current > k) {
            return;
        }

        for (int i = current; i <= 9; i++) {
            if (i > k) {
                break;
            }

            res.add(i);
            combinationSum3(k - i, n - 1, i + 1, res);
            res.remove(res.size() - 1);
        }
    }
}
