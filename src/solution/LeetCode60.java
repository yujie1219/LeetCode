package solution;

public class LeetCode60 {
    public static void main(String[] args) {
        LeetCode60 leetCode60 = new LeetCode60();
        System.out.println(leetCode60.getPermutation(9, 305645));
    }

    public String getPermutation(int n, int k) {
        int[] used = new int[n + 1];

        return getNowNum(n, k, used, "");
    }

    private String getNowNum(int n, int k, int[] used, String result) {
        if (n == 0) {
            return result;
        }

        int product = 1;
        for (int i = 1; i < n; i++) {
            product = product * i;
        }

        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i * product < k && (i + 1) * product >= k) {
                num = i + 1;
                break;
            }
        }

        int count = (num - 1) * product;
        int index = 0;
        while (num > 0) {
            index++;
            if (used[index] == 0) {
                num--;
            }
        }

        used[index] = 1;
        result += index;

        return getNowNum(n - 1, k - count, used, result);
    }
}
