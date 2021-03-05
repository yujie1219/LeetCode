package solution;

public class LeetCode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int left = 0;
            int right = A[i].length - 1;

            while (left < right) {
                int temp = A[i][left] ^ 1;
                A[i][left] = A[i][right] ^ 1;
                A[i][right] = temp;
                left++;
                right--;
            }

            if (left == right) {
                A[i][left] ^= 1;
            }
        }

        return A;
    }
}
