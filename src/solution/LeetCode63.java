package solution;

public class LeetCode63 {
	public static void main(String[] args) {
		LeetCode63 leetCode63 = new LeetCode63();
		System.out.print(leetCode63.uniquePathsWithObstacles(new int[][] { { 0, 0 } }));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		if (obstacleGrid[n - 1][m - 1] == 1) {
			return 0;
		}
		int[][] possiablePath = new int[n][m];
		possiablePath[0][0] = 1;
		for (int i = 0; i < m; i++) {
			addPath(obstacleGrid, possiablePath, 0, i, m, n);
		}
		return possiablePath[--n][--m];
	}

	private void addPath(int[][] obstacleGrid, int[][] possiablePath, int a, int b, int m, int n) {
		if (a == 0 && b == 0) {
			addPath(obstacleGrid, possiablePath, a + 1, b, m, n);
			return;
		}
		if (a >= n || b >= m) {
			return;
		}
		if (a == 0) {
			possiablePath[a][b] = obstacleGrid[a][b - 1] == 1 ? 0 : possiablePath[a][b - 1];
		} else if (b == 0) {
			possiablePath[a][b] = obstacleGrid[a - 1][b] == 1 ? 0 : possiablePath[a - 1][b];
		} else {
			possiablePath[a][b] = (obstacleGrid[a - 1][b] == 1 ? 0 : possiablePath[a - 1][b])
					+ (obstacleGrid[a][b - 1] == 1 ? 0 : possiablePath[a][b - 1]);
		}
		addPath(obstacleGrid, possiablePath, a + 1, b, m, n);
	}
}
