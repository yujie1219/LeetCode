package solution;

public class LeetCode81 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 2, 2};

        boolean result = new LeetCode81().search(nums, 1);
        System.out.println(result);
    }

    public boolean search(int[] nums, int target) {
        return disorderHalfSearch(nums, 0, nums.length - 1, target);
    }

    private boolean disorderHalfSearch(int[] nums, int start, int end, int target) {
        if ((start <= nums.length - 1 && nums[start] == target) || (end >= 0 && nums[end] == target)) {
            return true;
        }

        if (end - start <= 1) {
            return false;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return true;
        }

        if (nums[start] < target && nums[end] > target) {
            if (nums[mid] < target) {
                return halfSearch(nums, mid + 1, end, target);
            } else {
                return halfSearch(nums, start, mid - 1, target);
            }
        } else if (nums[start] > target) {
            if (nums[mid] > target) {
                return disorderHalfSearch(nums, start, mid - 1, target) || disorderHalfSearch(nums, mid + 1, end, target);
            } else {
                return halfSearch(nums, start, mid - 1, target) || disorderHalfSearch(nums, mid + 1, end, target);
            }
        } else if (nums[end] < target) {
            if (nums[mid] > target) {
                return halfSearch(nums, start, mid - 1, target);
            } else {
                return disorderHalfSearch(nums, start, mid - 1, target) || disorderHalfSearch(nums, mid + 1, end, target);
            }
        }

        return false;
    }

    private boolean halfSearch(int[] nums, int start, int end, int target) {
        if (end - start < 0) {
            return false;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return halfSearch(nums, mid + 1, end, target);
        } else {
            return halfSearch(nums, start, mid - 1, target);
        }
    }
}
