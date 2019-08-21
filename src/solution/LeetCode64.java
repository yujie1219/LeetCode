package solution;

public class LeetCode64 {

	public static void main(String[] args) {
		LeetCode64 leetCode64 = new LeetCode64();
		System.out.print(leetCode64.minPathSum(new int[][] { { 1, 2, 5 }, { 3, 2, 1 } }));
	}

	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		return getMinimum(grid, 0, 0, n - 1, m - 1);
	}

	private int getMinimum(int[][] grid, int a, int b, int m, int n) {
		if (a == m && b == n) {
			return grid[a][b];
		}
		if (a == m) {
			return grid[a][b] + getMinimum(grid, a, b + 1, m, n);
		}
		if (b == n) {
			return grid[a][b] + getMinimum(grid, a + 1, b, m, n);
		}
		int aResult = getMinimum(grid, a + 1, b, m, n);
		int bResult = getMinimum(grid, a, b + 1, m, n);
		return grid[a][b] + (aResult > bResult ? bResult : aResult);
	}
}
