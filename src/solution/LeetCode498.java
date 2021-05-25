package solution;

public class LeetCode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;

        if (m != 0) {
            int n = mat[0].length;
            int[] result = new int[m * n];

            findDiagonalOrder(mat, m, n, 0, 0, true, result, 0);

            return result;
        }

        return null;
    }

    private void findDiagonalOrder(int[][] mat, int m, int n, int x, int y, boolean toLeft, int[] result, int index) {
        if (toLeft) {
            while (x >= 0 && y < n) {
                result[index++] = mat[x][y];
                x--;
                y++;
            }

            if (y < n) {
                findDiagonalOrder(mat, m, n, x + 1, y, false, result, index);
            } else if (x + 2 < m) {
                findDiagonalOrder(mat, m, n, x + 2, y - 1, false, result, index);
            }
        } else {
            while (x < m && y >= 0) {
                result[index++] = mat[x][y];
                x++;
                y--;
            }

            if (x < m) {
                findDiagonalOrder(mat, m, n, x, y + 1, true, result, index);
            } else if (y + 2 < n) {
                findDiagonalOrder(mat, m, n, x - 1, y + 2, true, result, index);
            }
        }
    }
}
