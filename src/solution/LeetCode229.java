package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int candidate1 = nums[0];
        int count1 = 0;
        int candidate2 = nums[0];
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
                continue;
            }

            if (candidate2 == nums[i]) {
                count2++;
                continue;
            }

            if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
                continue;
            }

            if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        int realCount1 = 0;
        int realCount2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 > 0 && nums[i] == candidate1) {
                realCount1++;
            } else if (count2 > 0 && nums[i] == candidate2) {
                realCount2++;
            }
        }

        if (realCount1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (realCount2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}
