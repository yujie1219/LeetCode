package solution;

public class LeetCode79 {
	public static void main(String[] args) {
		LeetCode79 leetCode79 = new LeetCode79();
		System.out.print(leetCode79.exist(
				new char[][] { { 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A' } },
				"AAAAAAAAAAAAAAAAAA"));
	}

	public boolean exist(char[][] board, String word) {
		int n = board.length - 1;
		int m = board[0].length - 1;
		int[][] used = new int[n + 1][m + 1];
		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				if (isExist(board, 0, x, y, m, n, word, 0, used)) {
					return true;
				}
			}
		}
		return false;
	}

	/// fromwhere: 1-left,2-above,3-right,4-below
	private boolean isExist(char[][] board, int fromWhere, int x, int y, int m, int n, String word, int index,
			int used[][]) {
		if (x < 0 || x > m || y < 0 || y > n || used[y][x] == 1) {
			return false;
		}
		if (board[y][x] == word.charAt(index)) {
			used[y][x] = 1;
			if (index == word.length() - 1) {
				return true;
			}
			if (fromWhere != 1 && x != 0) {
				if (isExist(board, 3, x - 1, y, m, n, word, index + 1, used)) {
					return true;
				}
			}
			if (fromWhere != 2 && y != 0) {
				if (isExist(board, 4, x, y - 1, m, n, word, index + 1, used)) {
					return true;
				}
			}
			if (fromWhere != 3 && x != m) {
				if (isExist(board, 1, x + 1, y, m, n, word, index + 1, used)) {
					return true;
				}
			}
			if (fromWhere != 4 && y != n) {
				if (isExist(board, 2, x, y + 1, m, n, word, index + 1, used)) {
					return true;
				}
			}
		}
		used[y][x] = 0;
		return false;
	}
}
