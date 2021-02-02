package solution;

public class LeetCode887 {
    public int superEggDrop(int K, int N) {
        if (K == 1) {
            return N;
        }

        if (N == 1) {
            return 1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N + 1; i++) {
            result = Math.min(result, Math.max(superEggDrop(K - 1, N - 1), superEggDrop(K, N - i)) + 1);
        }

        return result;
    }
}
