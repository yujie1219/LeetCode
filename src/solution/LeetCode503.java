package solution;

import java.util.Stack;

public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        if (nums.length > 0) {
            int round = 1;
            Stack<Integer> indexStack = new Stack<>();
            indexStack.push(0);
            int i = 1;
            int max = nums[0];
            while (!indexStack.isEmpty()) {
                if (round == 1) {
                    if (i == nums.length) {
                        round++;
                        i = 0;
                        continue;
                    }

                    max = Math.max(nums[i], max);
                    if (nums[indexStack.peek()] < nums[i]) {
                        while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i]) {
                            result[indexStack.pop()] = nums[i];
                        }
                    }

                    indexStack.push(i);
                    i++;
                } else {
                    if (nums[indexStack.peek()] == max) {
                        result[indexStack.pop()] = -1;
                        continue;
                    }

                    if (nums[indexStack.peek()] < nums[i]) {
                        while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i]) {
                            result[indexStack.pop()] = nums[i];
                        }
                    }

                    i = (i + 1) % nums.length;
                }
            }
        }

        return result;
    }
}
