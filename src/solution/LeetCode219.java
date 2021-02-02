package solution;

import java.util.*;

public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Queue<Integer>> value2Index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (!value2Index.containsKey(key)) {
                value2Index.put(key, new LinkedList<>());
            }

            value2Index.get(key).add(i);
        }

        for (Integer key : value2Index.keySet()) {
            Queue<Integer> indexes = value2Index.get(key);
            while (indexes.size() > 1) {
                if (Math.abs(indexes.poll() - indexes.peek()) <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}
