package solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            if (!num2Count.containsKey(num)) {
                num2Count.put(num, 0);
            }
            num2Count.put(num, num2Count.get(num) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]));

        for (int key : num2Count.keySet()) {
            if (queue.size() < k) {
                queue.offer(new int[]{key, num2Count.get(key)});
            } else if (queue.peek()[1] < num2Count.get(key)) {
                queue.poll();
                queue.offer(new int[]{key, num2Count.get(key)});
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll()[0];
        }

        return result;
    }
}
