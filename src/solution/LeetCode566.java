package solution;

public class LeetCode566 {

    // 行数为m，列数为n的二维数组映射为一维数组， 下标 i , j 对应一位数组的位置是 i * n + j，因此反过来这个一维数组如果要变为一个 行数为r, 列数为c的二维数组，那么 下标 x 对应的 i = x / c, j = x % c
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;

        if (n != 0) {
            int m = nums[0].length;
            if (m * n == r * c) {
                int i = 0;
                int j = 0;
                int[][] result = new int[r][c];
                for (int k = 0; k < r; k++) {
                    for (int t = 0; t < c; t++) {
                        result[k][t] = nums[i][j++];
                        if (j == m) {
                            j = 0;
                            i++;
                        }
                    }
                }

                return result;
            }
        }

        return nums;
    }
}
