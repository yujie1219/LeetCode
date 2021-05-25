package solution;

public class LeetCode457 {
    public static void main(String[] args) {
        System.out.println(new LeetCode457().circularArrayLoop(new int[]{2, -1, 1, -2 - 2}));
    }

    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        int numLength = nums.length;
        int[] cache = new int[numLength];

        for (int j = 0; j < numLength; j++) {
            if (cache[j] == 0) {
                int[] used = new int[numLength];
                boolean current = nums[j] > 0;  // true 代表当前循环为正， false 代表当前循环为负

                int i = j;
                boolean jump = false;
                while (used[i] == 0) {
                    used[i] = 1;
                    cache[i] = 1;

                    if ((nums[i] > 0 && !current) || (nums[i] < 0 && current)) {
                        jump = true;
                        break;
                    }

                    i += nums[i];
                    i = i >= 0 ? (i % numLength) : (numLength + i % numLength);
                }

                if (jump) {
                    continue;
                }

                int next = i + nums[i];
                next = next >= 0 ? (next % numLength) : (numLength + next % numLength);
                int loopLength = 1;

                while (next != i) {
                    next = next + nums[next];
                    next = next >= 0 ? (next % numLength) : (numLength + next % numLength);
                    loopLength++;
                }

                if (loopLength > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
