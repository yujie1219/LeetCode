package solution;

public class LeetCode74Re {

    public static void main(String[] args) {
        LeetCode74Re leetCode74Re = new LeetCode74Re();

        System.out.println(leetCode74Re.searchMatrix(new int[][]{new int[]{1}, new int[]{3}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        if (target < matrix[0][0] || target > matrix[m][n]) {
            return false;
        }

        int rightTop = matrix[0][n];
        int leftBottom = matrix[m][0];
        if (target <= rightTop) {
            for (int i = n; i >= 0; i--) {
                if (target == matrix[0][i]) {
                    return true;
                } else if (target > matrix[0][i]) {
                    return false;
                }
            }

            return false;
        } else if (target >= leftBottom) {
            for (int i = 0; i <= n; i++) {
                if (target == matrix[m][i]) {
                    return true;
                } else if (target < matrix[m][i]) {
                    return false;
                }
            }

            return false;
        } else {
            if (target - rightTop > leftBottom - target) {
                int i = m;
                int j = 0;

                while (isValid(i, m) && isValid(j, n)) {
                    if (matrix[i][j] > target) {
                        i--;
                    } else if (matrix[i][j] < target) {
                        j++;
                    } else {
                        return true;
                    }
                }

                return false;
            } else {
                int i = 0;
                int j = n;

                while (isValid(i, m) && isValid(j, n)) {
                    if (matrix[i][j] > target) {
                        j--;
                    } else if (matrix[i][j] < target) {
                        i++;
                    } else {
                        return true;
                    }
                }

                return false;
            }
        }
    }

    private boolean isValid(int num, int board) {
        return num >= 0 && num <= board;
    }
}
