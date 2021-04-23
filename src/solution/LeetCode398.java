package solution;

import java.util.*;

public class LeetCode398 {
    private Map<Integer, List<Integer>> value2Index;

    public LeetCode398(int[] nums) {
        value2Index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!value2Index.containsKey(num)) {
                value2Index.put(num, new ArrayList<>());
            }

            value2Index.get(num).add(i);
        }
    }

    public int pick(int target) {
        Random random = new Random();
        List<Integer> indexes = value2Index.get(target);

        int i = 1;
        int result = indexes.get(0);
        for (Integer index : indexes) {
            result = random.nextInt(i) % i == 0 ? index : result;
            i++;
        }

        return result;
    }
}
