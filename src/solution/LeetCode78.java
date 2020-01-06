package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode78 {

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        List<List<Integer>> results = leetCode78.subsets(new int[]{1, 2, 3});
        for (List<Integer> result : results) {
            System.out.print("[");
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1)
                    System.out.print(",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> container = new ArrayList(
                Arrays.stream(nums).mapToObj(item -> item).collect(Collectors.toList()));

        for (int i = 0; i <= nums.length; i++) {
            subset(i, container, new ArrayList<>(), results);
        }

        return results;
    }

    private void subset(int n, List<Integer> container, List<Integer> result, List<List<Integer>> results) {
        if (n == 0) {
            results.add(result);
        }

        for (int i = 0; i < container.size(); i++) {
            List<Integer> alter = new ArrayList<>(container);
            if (result.size() != 0 && alter.get(i) < result.get(result.size() - 1)) {
                continue;
            }
            List<Integer> tmpResult = new ArrayList<>(result);
            tmpResult.add(container.get(i));
            alter.remove(i);
            subset(n - 1, alter, tmpResult, results);
        }
    }


}
