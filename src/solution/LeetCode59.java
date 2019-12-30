package solution;

public class LeetCode59 {
    // timeout
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int value = 1;
        int x = 0;
        int y = 0;
        int h = n;
        int v = n;
        while (value <= Math.pow(n, 2)) {
            for (int i = 0; i < h; i++) {
                result[y][x] = value;
                value++;
                x++;
            }
            x--;
            y++;
            v--;
            for (int i = 0; i < v; i++) {
                result[y][x] = value;
                value++;
                y++;
            }
            y--;
            x--;
            h--;
            for (int i = 0; i < h; i++) {
                result[y][x] = value;
                value++;
                x--;
            }
            x++;
            y--;
            v--;
            for (int i = 0; i < v; i++) {
                result[y][x] = value;
                value++;
                y--;
            }
            y++;
            x++;
            h--;
        }

        return result;
    }
}
