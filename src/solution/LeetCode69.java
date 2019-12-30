package solution;

public class LeetCode69 {
    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        System.out.println(leetCode69.mySqrt(144));
    }

    public int mySqrt(int x) {
        int target = x;
        int result = 0;
        while (true) {
            int half = target / 2;
            if (Math.pow(half, 2F) <= x) {
                result = half;
                break;
            }
            target = half;
        }

        while (!(Math.pow(result, 2) <= x && Math.pow(result + 1, 2) > x)) {
            result++;
        }

        return result;
    }
}
