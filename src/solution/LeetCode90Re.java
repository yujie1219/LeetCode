package solution;

import java.util.*;

public class LeetCode90Re {
    List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        new LeetCode90Re().subsetsWithDup(new int[]{1, 2, 2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsets(nums, new ArrayList<>(), 0);

        return new ArrayList<>(results);
    }

    private void subsets(int[] nums, List<Integer> result, int currentIndex) {
        if (contains(result, results)) {
            return;
        }

        results.add(new ArrayList<>(result));
        if (currentIndex > nums.length - 1) {
            return;
        }

        for (int i = currentIndex; i < nums.length; i++) {
            result.add(nums[i]);
            subsets(nums, result, i + 1);
            result.remove(result.size() - 1);
        }
    }

    private boolean contains(List<Integer> A, List<List<Integer>> B) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer e : A) {
            if (!map.containsKey(e)) {
                map.put(e, 0);
            }

            map.put(e, map.get(e) + 1);
        }

        Map<Integer, Integer> temp = null;
        for (List<Integer> C : B) {
            temp = new HashMap<>(map);
            boolean shouldNext = false;
            for (Integer e : C) {
                if (!temp.containsKey(e)) {
                    shouldNext = true;
                    break;
                } else {
                    temp.put(e, temp.get(e) - 1);
                }
            }

            if (shouldNext) {
                continue;
            }

            for (Integer v : temp.values()) {
                if (v != 0) {
                    shouldNext = true;
                    break;
                }
            }

            if (shouldNext) {
                continue;
            }

            return true;
        }

        return false;
    }
}
