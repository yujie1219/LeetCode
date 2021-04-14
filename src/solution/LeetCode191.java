package solution;

public class LeetCode191 {
    public static void main(String[] args) {
        new LeetCode191().hammingWeight(00000000000000000000000000001011);
    }

    // 	n & (n - 1) 会把n的二进制位中最低位的1变为0
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
