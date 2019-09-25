package solution;

import java.util.HashSet;
import java.util.Set;

public class LeetCode73 {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		Set<Integer> exist = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				exist.add(matrix[i][j]);
			}
		}

		int notExist = 0;
		while (exist.contains(notExist)) {
			notExist++;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					markNotExist(i, j, m, n, matrix, notExist);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == notExist) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private void markNotExist(int i, int j, int m, int n, int[][] matrix, int notExist) {
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (matrix[x][y] != 0 && (x == i || y == j)) {
					matrix[x][y] = notExist;
				}
			}
		}
	}
}
