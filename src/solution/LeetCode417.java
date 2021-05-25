package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return result;
        }

        int n = heights.length;
        int m = heights[0].length;

        int[][] toPacific = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, toPacific, visited, true, result);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, 0, i, toPacific, visited, true, result);
        }

        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, i, m - 1, toPacific, visited, false, result);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, n - 1, i, toPacific, visited, false, result);
        }

        return result;
    }

    private void dfs(int[][] heights, int x, int y, int[][] toPacific, int[][] visited, boolean isToPacific, List<List<Integer>> result) {
        if (visited[x][y] == 1) {
            return;
        }

        int n = heights.length;
        int m = heights[0].length;

        if (isToPacific) {
            toPacific[x][y] = 1;
        } else if (toPacific[x][y] == 1) {
            result.add(Arrays.asList(x, y));
        }

        visited[x][y] = 1;

        if (x > 0 && heights[x - 1][y] >= heights[x][y]) {
            dfs(heights, x - 1, y, toPacific, visited, isToPacific, result);
        }

        if (x < n - 1 && heights[x + 1][y] >= heights[x][y]) {
            dfs(heights, x + 1, y, toPacific, visited, isToPacific, result);
        }

        if (y > 0 && heights[x][y - 1] >= heights[x][y]) {
            dfs(heights, x, y - 1, toPacific, visited, isToPacific, result);
        }

        if (y < m - 1 && heights[x][y + 1] >= heights[x][y]) {
            dfs(heights, x, y + 1, toPacific, visited, isToPacific, result);
        }

    }
}
