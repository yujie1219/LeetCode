package solution;

public class LeetCode861 {
    public static void main(String[] args) {
        int[] A1 = new int[]{0, 0, 1, 1};
        int[] A2 = new int[]{1, 0, 1, 0};
        int[] A3 = new int[]{1, 1, 0, 0};
        int[][] A = new int[][]{A1, A2, A3};
        new LeetCode861().matrixScore(A);
    }

    public int matrixScore(int[][] A) {
        int result = 0;
        if (A != null) {
            if (A.length > 0) {
                for (int i = 0; i < A.length; i++) {
                    doReverseRow(A, i);
                }

                for (int i = 1; i < A[0].length; i++) {
                    doReverseCol(A, i);
                }

                result = (int) toNum(A);
            }
        }

        return result;
    }

    private double toNum(int[][] A) {
        int length = A[0].length;
        double result = 0;
        for (int i = 0; i < A.length; i++) {
            int[] current = A[i];
            int cifang = length - 1;
            for (int j = 0; j < length; j++) {
                result += current[j] * Math.pow(2, cifang--);
            }
        }

        return result;
    }

    private void doReverseRow(int[][] A, int row) {
        int[] current = A[row];
        if (current[0] != 1) {
            reverseRow(A, row);
        }
    }

    private void doReverseCol(int[][] A, int col) {
        int zeroNum = 0;
        int oneNum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][col] == 0) {
                zeroNum++;
            } else {
                oneNum++;
            }
        }

        if (zeroNum > oneNum) {
            reverseCol(A, col);
        }
    }

    private void reverseCol(int[][] A, int col) {
        for (int i = 0; i < A.length; i++) {
            A[i][col] = A[i][col] == 0 ? 1 : 0;
        }
    }

    private void reverseRow(int[][] A, int row) {
        int[] current = A[row];
        for (int i = 0; i < current.length; i++) {
            current[i] = current[i] == 0 ? 1 : 0;
        }
    }
}
