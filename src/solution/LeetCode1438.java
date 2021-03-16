package solution;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1438 {
    private int currentMax = Integer.MIN_VALUE;
    private int currentMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        new LeetCode1438().longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5);
    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int right = 0;

        int result = 0;

        while (right <= nums.length - 1) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }

            maxDeque.offerLast(nums[right]);
            minDeque.offerLast(nums[right]);

            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }

                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }

                left++;
            }

            int temp = right - left + 1;
            result = result > temp ? result : temp;

            right++;
        }

        return result;
    }

//    public int longestSubarray(int[] nums, int limit) {
//        int left = 0;
//        int right = 0;
//
//        currentMin = nums[0];
//        currentMax = nums[0];
//
//        int result = 1;
//
//        while (right < nums.length - 1) {
//            right++;
//
//            int current = nums[right];
//            if (current > currentMax) {
//                currentMax = current;
//            } else if (current < currentMin) {
//                currentMin = current;
//            }
//
//            while (currentMax - currentMin > limit) {
//                if (nums[left] == currentMin || nums[left] == currentMax) {
//                    findCurrentMaxAndMin(nums, ++left, right);
//                } else {
//                    left++;
//                }
//            }
//
//            int tempLength = right - left + 1;
//            result = tempLength > result ? tempLength : result;
//        }
//
//        return result;
//    }
//
//    private void findCurrentMaxAndMin(int[] nums, int start, int end) {
//        currentMax = Integer.MIN_VALUE;
//        currentMin = Integer.MAX_VALUE;
//
//        for (int i = start; i <= end; i++) {
//            int current = nums[i];
//            if (currentMax < current) {
//                currentMax = current;
//            }
//
//            if (currentMin > current) {
//                currentMin = current;
//            }
//        }
//    }
}
