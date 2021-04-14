package solution;

public class LeetCode400 {
    public static void main(String[] args) {
        System.out.println(new LeetCode400().findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        long base = 9;
        int length = 1;

        long summary = 0;
        while (summary + base * length < n) {
            summary += base * length;
            base *= 10;
            length++;
        }

        long remain = n - summary;
        base = (long) (Math.pow(10, length - 1) - 1);

        long addNum = remain / length;
        long actualLoc = remain % length;
        long actualNum = base + addNum;

        if (actualLoc == 0) {
            String actualNumStr = actualNum + "";
            return Integer.parseInt(actualNumStr.substring(actualNumStr.length() - 1));
        } else {
            String actualNumStr = (actualNum + 1) + "";
            return Integer.parseInt(actualNumStr.substring((int) actualLoc - 1, (int) actualLoc));
        }
    }
}
