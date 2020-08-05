package solution;

public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums[0] > nums[1]) {
            return 0;
        } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        return halfFindPeak(nums, 1, nums.length - 2);
    }

    public int halfFindPeak(int[] nums, int begin, int end) {
//        if (begin - end == 1) {
//            if (nums[begin - 1] < nums[begin] && nums[begin] > nums[end]) {
//                return begin;
//            } else if (nums[begin] < nums[end] && nums[end] > nums[end + 1]) {
//                return end;
//            } else {
//                return -1;
//            }
//        }

        if (begin == end) {
            if (nums[begin - 1] < nums[begin] && nums[begin] > nums[begin + 1]) {
                return begin;
            } else {
                return -1;
            }
        }

        int mid = (begin + end) / 2;
        if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        return Math.max(halfFindPeak(nums, begin, mid - 1), halfFindPeak(nums, mid + 1, end));
    }
}
