package solution;

public class LeetCode304 {
    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
    }

    static class NumMatrix {
        int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length != 0 && matrix[0].length != 0) {
                this.init(matrix);
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int reduce = 0;
            int reduceCount = 0;
            if (row1 != 0) {
                reduceCount++;
                reduce += this.sum[row1 - 1][col2];
            }

            if (col1 != 0) {
                reduceCount++;
                reduce += this.sum[row2][col1 - 1];
            }

            int add = 0;
            if (reduceCount == 2) {
                add = this.sum[row1 - 1][col1 - 1];
            }

            return this.sum[row2][col2] - reduce + add;
        }

        private void init(int[][] martix) {
            int n = martix.length;
            int m = martix[0].length;

            this.sum = new int[n][m];
            this.sum[0][0] = martix[0][0];

            for (int j = 1; j < m; j++) {
                this.sum[0][j] = this.sum[0][j - 1] + martix[0][j];
            }

            for (int i = 1; i < n; i++) {
                this.sum[i][0] = this.sum[i - 1][0] + martix[i][0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    this.sum[i][j] = this.sum[i - 1][j] + this.sum[i][j - 1] - this.sum[i - 1][j - 1] + martix[i][j];
                }
            }
        }
    }
}
