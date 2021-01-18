package solution;

public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    foo(grid, j, i);
                }
            }
        }

        return result;
    }

    private void foo(char[][] grid, int y, int x) {
        if (grid[x][y] == '1') {
            grid[x][y] = '2';

            if (x != 0) {
                foo(grid, y, x - 1);
            }

            if (x != grid.length - 1) {
                foo(grid, y, x + 1);
            }

            if (y != 0) {
                foo(grid, y - 1, x);
            }

            if (y != grid[x].length - 1) {
                foo(grid, y + 1, x);
            }
        }
    }
}
