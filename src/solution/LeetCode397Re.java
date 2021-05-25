package solution;

public class LeetCode397Re {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            if (n == 3) {
                return integerReplacement(n - 1) + 1;
            }

            if (addOne(n)) {
                return integerReplacement(n + 1) + 1;
            } else {
                return integerReplacement(n - 1) + 1;
            }
        }
    }

    private boolean addOne(int n) {
        int num1 = n % 2;
        n = n / 2;
        int num2 = n % 2;

        return num1 == 1 && num2 == 1;
    }
}
