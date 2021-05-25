package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode452 {
    public static void main(String[] args) {
        new LeetCode452().findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] p1, int[] p2) -> {
            return p1[0] <= p2[0] ? -1 : 1;
        });
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < points.length; i++) {
            int[] current = points[i];
            Queue<int[]> temp = new LinkedList<>();
            boolean first = true;
            while (!queue.isEmpty()) {
                int[] previous = queue.poll();

                if (!first) {
                    temp.offer(previous);
                    continue;
                }

                if (current[0] <= previous[1]) {
                    current[1] = Math.min(previous[1], current[1]);
                } else if (first) {
                    temp.offer(current);
                    temp.offer(previous);
                    first = false;
                }
            }

            queue = temp;
            if (queue.isEmpty()) {
                queue.offer(current);
            }
        }

        return queue.size();
    }
}
