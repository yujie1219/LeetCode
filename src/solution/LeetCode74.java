package solution;

public class LeetCode74 {
    public static void main(String[] args) {
        LeetCode74 leetCode74 = new LeetCode74();

        System.out.println(leetCode74.searchMatrix(new int[][]{new int[]{1}, new int[]{3}}, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }

        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }

        n = n - 1;
        m = m - 1;
        if (matrix[n][m] < target || matrix[0][0] > target) {
            return false;
        }

        return findHalfMatrix(matrix, n / 2, m / 2, n, m, target);
    }

    private boolean findHalfMatrix(int[][] matrix, int y, int x, int n, int m, int target) {

        if (matrix[y][x] > target) {
            if (y == 0 && x == 0) {
                return matrix[0][0] == target;
            }

            return findHalfMatrix(matrix, y / 2, x / 2, n, m, target);
        } else if (matrix[y][x] < target) {
            return findMatrix(matrix, y, x, n, m, target);
        } else {
            return true;
        }
    }

    private boolean findMatrix(int[][] matrix, int y, int x, int n, int m, int target) {
        if (y > n) {
            return false;
        }

        while (x <= m && matrix[y][x] < target ) {
            x++;
        }

        if (x <= m) {
            return matrix[y][x] == target;
        }

        return findMatrix(matrix, y + 1, 0, n, m, target);
    }
}
