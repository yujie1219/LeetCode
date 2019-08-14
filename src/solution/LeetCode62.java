package solution;

public class LeetCode62 {
	public static void main(String[] args) {
		LeetCode62 leetCode62 = new LeetCode62();
		System.out.print(leetCode62.uniquePaths(7, 3));
	}

	public int uniquePaths(int m, int n) {
		int[][] possiablePath = new int[m][n];
		for (int i = 0; i < n; i++) {
			possiablePath[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			possiablePath[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			addPath(possiablePath, 1, i, m, n);
		}
		return possiablePath[--m][--n];
	}

	private void addPath(int[][] possiablePath, int a, int b, int m, int n) {
		if (a >= m || b >= n || possiablePath[a][b] != 0) {
			return;
		}
		possiablePath[a][b] = possiablePath[a - 1][b] + possiablePath[a][b - 1];
		addPath(possiablePath, a + 1, b, m, n);
	}
}
