package solution;

import java.util.PriorityQueue;

public class LeetCode1046 {
    public static void main(String[] args) {
        new LeetCode1046().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> biggestQueue = new PriorityQueue<Integer>((x, y) -> y - x);

        for (int i = 0; i < stones.length; i++) {
            biggestQueue.add(stones[i]);
        }

        while (biggestQueue.size() > 1) {
            int a = biggestQueue.poll();
            int b = biggestQueue.poll();
            int result = a - b;
            if (result != 0) {
                biggestQueue.add(result);
            }
        }

        return biggestQueue.isEmpty() ? 0 : biggestQueue.poll();
    }
}
