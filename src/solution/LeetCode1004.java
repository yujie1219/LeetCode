package solution;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1004 {
    public int longestOnes(int[] A, int K) {
        int zeroNum = 0;

        int right = 0;
        int left = 0;
        int result = 0;

        while (right < A.length) {
            if (A[right] == 0) {
                zeroNum++;
            }

            if (zeroNum > K) {
                while (A[left++] != 0) {
                }

                zeroNum--;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
