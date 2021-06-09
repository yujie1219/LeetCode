package solution;

public class LeetCode240 {
    public static void main(String[] args) {
        new LeetCode240().searchMatrix(new int[][]{{1, 2, 3, 4, 5}}, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }

        if (Math.abs(target - matrix[0][matrix[0].length - 1]) < Math.abs(target - matrix[matrix.length - 1][0])) {
            return startFromLeftTop(matrix, 0, matrix[0].length - 1, target);
        } else {
            return startFromRightBottom(matrix, matrix.length - 1, 0, target);
        }
    }

    private boolean startFromRightBottom(int[][] matrix, int x, int y, int target) {
        if (x < 0 || y >= matrix[0].length) {
            return false;
        }

        if (matrix[x][y] < target) {
            return startFromRightBottom(matrix, x, y + 1, target);
        } else if (matrix[x][y] == target) {
            return true;
        } else {
            return startFromRightBottom(matrix, x - 1, y, target);
        }
    }

    private boolean startFromLeftTop(int[][] matrix, int x, int y, int target) {
        if (x >= matrix.length || y < 0) {
            return false;
        }

        if (matrix[x][y] < target) {
            return startFromLeftTop(matrix, x + 1, y, target);
        } else if (matrix[x][y] == target) {
            return true;
        } else {
            return startFromLeftTop(matrix, x, y - 1, target);
        }
    }
}
