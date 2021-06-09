package solution;

public class LeetCode1049 {
    public static void main(String[] args) {
        new LeetCode1049().lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = getSum(stones);

        int maxHalf = lastStoneWeightII(stones, 0, 0, sum / 2);

        return sum - 2 * maxHalf;
    }

    private int lastStoneWeightII(int[] stones, int current, int currentSum, int target) {
        if (current == stones.length) {
            return currentSum;
        }

        int temp = currentSum;
        for (int i = current; i < stones.length; i++) {
            if (currentSum + stones[i] < target) {
                temp = Math.max(temp, lastStoneWeightII(stones, i + 1, currentSum + stones[i], target));

                if (temp == target) {
                    break;
                }
            } else if (currentSum + stones[i] == target) {
                return target;
            }
        }

        return temp;
    }

    private int getSum(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        return sum;
    }
}
