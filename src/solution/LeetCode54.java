package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		int n = matrix.length;
		if (n == 0) {
			return new ArrayList<Integer>();
		}
		int m = matrix[0].length;

		int[][] passed = new int[n][m];
		List<Integer> result = new ArrayList<Integer>();
		pass(matrix, passed, m - 1, n - 1, 0, 0, result, 1);

		return result;
	}

	private void pass(int[][] matrix, int[][] passed, int m, int n, int x, int y, List<Integer> result, int direct) {
		passed[y][x] = 1;
		result.add(matrix[y][x]);
		if (direct == 1 && x < m && passed[y][x + 1] != 1) {
			pass(matrix, passed, m, n, x + 1, y, result, 1);
		} else if (direct == 2 && y < n && passed[y + 1][x] != 1) {
			pass(matrix, passed, m, n, x, y + 1, result, 2);
		} else if (direct == 3 && x > 0 && passed[y][x - 1] != 1) {
			pass(matrix, passed, m, n, x - 1, y, result, 3);
		} else if (direct == 4 && y > 0 && passed[y - 1][x] != 1) {
			pass(matrix, passed, m, n, x, y - 1, result, 4);
		}
		if (x < m && passed[y][x + 1] != 1) {
			pass(matrix, passed, m, n, x + 1, y, result, 1);
		} else if (y < n && passed[y + 1][x] != 1) {
			pass(matrix, passed, m, n, x, y + 1, result, 2);
		} else if (x > 0 && passed[y][x - 1] != 1) {
			pass(matrix, passed, m, n, x - 1, y, result, 3);
		} else if (y > 0 && passed[y - 1][x] != 1) {
			pass(matrix, passed, m, n, x, y - 1, result, 4);
		}
	}
}
