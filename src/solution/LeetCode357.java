package solution;

public class LeetCode357 {
    public static void main(String[] args) {
        new LeetCode357().countNumbersWithUniqueDigits(1);
    }

    public int countNumbersWithUniqueDigits(int n) {
        return countNumberWithOutZero(n) + countNumberWithZero(n);
    }

    private int countNumberWithOutZero(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int current = i;
            int temp = 1;

            while (current > 0) {
                temp *= (9 - current + 1);
                current--;
            }

            sum += temp;
        }

        return sum;
    }

    private int countNumberWithZero(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            int current = i;
            int temp = current - 1;

            while (current - 1 > 0) {
                temp *= (9 - current + 2);
                current--;
            }

            sum += temp;
        }

        return sum;
    }
}
