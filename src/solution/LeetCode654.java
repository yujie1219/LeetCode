package solution;

import model.TreeNode;

public class LeetCode654 {
    public static void main(String[] args) {
        new LeetCode654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int start, int end) {
        TreeNode current = null;
        if (end < nums.length && start >= 0) {
            if (end - start > 0) {
                int currentIndex = findMaxIndex(nums, start, end);
                current = new TreeNode(nums[currentIndex]);
                current.left = constructTree(nums, start, currentIndex -1);
                current.right = constructTree(nums, currentIndex + 1, end);
            } else if (end - start == 0) {
                current = new TreeNode(nums[start]);
            }
        }

        return current;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
