package solution;

public class LeetCode306 {
    public boolean isAdditiveNumber(String num) {
        return isAdditiveNumber(num, 0, 0, 0, 0);
    }

    private boolean isAdditiveNumber(String num, int currentIndex, int numCount, long num1, long num2) {
        if (currentIndex == num.length()) {
            return numCount >= 3;
        }

        if (numCount < 2) {
            for (int i = 1; i < num.length() - currentIndex; i++) {
                long currentNum = Long.parseLong(num.substring(currentIndex, currentIndex + i));
                if (numCount == 0) {
                    if (isAdditiveNumber(num, currentIndex + i, numCount + 1, currentNum, num2)) {
                        return true;
                    }
                } else {
                    if (isAdditiveNumber(num, currentIndex + i, numCount + 1, num1, currentNum)) {
                        return true;
                    }
                }
                if (currentNum == 0) {
                    return false;
                }
            }
        } else {
            long result = num1 + num2;
            int length = (result + "").length();
            if (currentIndex + length > num.length()) {
                return false;
            }

            if (Long.parseLong(num.substring(currentIndex, currentIndex + length)) == result) {
                return isAdditiveNumber(num, currentIndex + length, numCount + 1, num2, result);
            } else {
                return false;
            }
        }

        return false;
    }
}
