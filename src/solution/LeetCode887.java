package solution;

public class LeetCode887 {
    // v[k][n] 代表在有K个鸡蛋的情况下，从第n层开始扔，最少要扔鸡蛋的次数
    // v[k][n] = max(v[k-1][n-1], v[k][N-n]) + 1  代表如果第n层扔鸡蛋没碎，那么问题就会变为 从剩下的N-n层中找到扔鸡蛋会碎的那层要扔的最少次数+ 1
    //                                                如果第n层扔鸡蛋碎了，那么问题就会变为 从之前的n-1层中找到扔鸡蛋会碎的那层要扔的最少次数+ 1
    //                                                最坏情况，因此取两者的更大值
    // 当k = 1 的时候，v[k][n] = n                 代表只有一个鸡蛋的时候，最坏情况要从1楼扔到n楼
    // 当n = 1 的时候, v[k][n] = 1                 代表只有一层楼的时候，那么无论如何只需要扔一次
    public int superEggDrop(int K, int N) {
        if (K == 1 || N == 1) {
            return N;
        }

        int[][] v = new int[K + 1][N + 1];

        this.fillNumber(K, N, v);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            result = Math.min(result, v[K][i]);
        }

        return result;
    }

    private int fillNumber(int k, int n, int[][] v) {
        if (v[k][n] != 0) {
            return v[k][n];
        }

        for (int i = 2; i <= n; i++) {
            v[k][i] = Math.max(fillNumber(k - 1, i - 1, v), fillNumber(k, n - i, v)) + 1;
        }

        if (k == 1) {
            v[k][n] = n;
            return n;
        }

        if (n == 1) {
            v[k][n] = 1;
            return 1;
        }

        return v[k][n];
    }
}
