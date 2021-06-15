package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new Integer[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x > 0 && result[x - 1][y] == Integer.MAX_VALUE) {
                result[x - 1][y] = result[x][y] + 1;
                queue.offer(new Integer[]{x - 1, y});
            }

            if (x < m - 1 && result[x + 1][y] == Integer.MAX_VALUE) {
                result[x + 1][y] = result[x][y] + 1;
                queue.offer(new Integer[]{x + 1, y});
            }

            if (y > 0 && result[x][y - 1] == Integer.MAX_VALUE) {
                result[x][y - 1] = result[x][y] + 1;
                queue.offer(new Integer[]{x, y - 1});
            }

            if (y < n - 1 && result[x][y + 1] == Integer.MAX_VALUE) {
                result[x][y + 1] = result[x][y] + 1;
                queue.offer(new Integer[]{x, y + 1});
            }
        }

        return result;
    }
}
