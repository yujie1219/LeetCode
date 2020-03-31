package solution;

import model.TreeNode;

public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (end - start == 0) {
            return new TreeNode(nums[start]);
        }else if(end - start <= 0){
            return null;
        }
        int mid = (start + end + 1) / 2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = buildTree(nums, start, mid - 1);
        current.right = buildTree(nums, mid + 1, end);

        return current;
    }
}
