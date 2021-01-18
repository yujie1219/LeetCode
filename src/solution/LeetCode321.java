package solution;

import java.util.Stack;

public class LeetCode321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] num1MaxStack = findMaxNum(nums1, i);
            int[] num2MaxStack = findMaxNum(nums2, i);
        }

        return new int[0];
    }

    private int[] findMaxNum(int[] nums, int target) {
        int[] stack = new int[target];
        int remain = nums.length - target;
        int top = -1;
        for (int i = 0; i < nums.length; i++) {
            while (top >= 0 && stack[top] < nums[i] && remain != 0) {
                top--;
                remain--;
            }

            if (top < target) {
                stack[++top] = nums[i];
            } else {
                remain--;
            }
        }

        return stack;
    }
}
