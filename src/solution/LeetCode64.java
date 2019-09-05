package solution;

public class LeetCode64 {

	public static void main(String[] args) {
		LeetCode64 leetCode64 = new LeetCode64();
		System.out.print(leetCode64.minPathSum(new int[][] { { 1, 2, 5 }, { 3, 2, 1 } }));
	}

	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] minPath = new int[n][m];
		minPath[0][0] = grid[0][0];

		return minPath(grid, minPath, m - 1, n - 1);
	}

	private int minPath(int[][] grid, int[][] minPath, int x, int y) {
		if (x < 0 || y < 0) {
			return -1;
		}
		if (minPath[y][x] != 0) {
			return minPath[y][x];
		}
		int aPath = minPath(grid, minPath, x, y - 1);
		int bPath = minPath(grid, minPath, x - 1, y);
		if (aPath == -1) {
			aPath = bPath + 1;
		}
		if (bPath == -1) {
			bPath = aPath + 1;
		}
		minPath[y][x] = grid[y][x] + (aPath > bPath ? bPath : aPath);
		return minPath[y][x];
	}
}
