package solution;

public class LeetCode201 {
    public int rangeBitwiseAnd(int m, int n) {
        int moveRightCount = 0;
        while (m != n) {
            m = m / 2;
            n = n / 2;
            moveRightCount++;
        }

        return (int) Math.pow(2, moveRightCount) * m;
    }
}
