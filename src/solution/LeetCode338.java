package solution;

public class LeetCode338 {

    // 对于数字x，右移一位等同于X/2 ，此时如果x原本是偶数，则1的个数不变，如果是奇数，则x比X/2多一个1
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num >= 0) {
            result[1] = 1;
            for (int i = 2; i <= num; i++) {
                result[i] = result[i / 2] + i % 2;
            }
        }

        return result;
    }
}
