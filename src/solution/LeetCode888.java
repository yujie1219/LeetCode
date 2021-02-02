package solution;

public class LeetCode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = this.sum(A);
        int sumB = this.sum(B);

        int gap = (sumA - sumB) / 2;

        int[] result = new int[2];
        for (int i = 0; i < B.length; i++) {
            int existIndex = isExist(A, B[i] + gap);
            if (existIndex != -1) {
                result[0] = A[existIndex];
                result[1] = B[i];
            }
        }

        return result;
    }

    private int sum(int[] arr) {
        int result = 0;
        for (int e : arr) {
            result += e;
        }

        return result;
    }

    private int isExist(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }

        return -1;
    }
}
