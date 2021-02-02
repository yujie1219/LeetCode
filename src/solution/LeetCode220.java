package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode220 {
    public static void main(String[] args) {
        new LeetCode220().containsNearbyAlmostDuplicate(new int[]{4, 1, 6, 3}, 100, 1);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || k == 0) {
            return false;
        }

        List<Integer> dw = new ArrayList<>();
        dw.add(nums[0]);
        long[] max = new long[1];
        max[0] = nums[0];
        long[] min = new long[1];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (satisfy(max[0], min[0], nums[i], t)) {
                return true;
            }
            dw.add(nums[i]);
            if (dw.size() > k) {
                int remove = nums[i - k];
                dw.remove((Integer) remove);
                if (max[0] == remove || min[0] == remove) {
                    updateMaxOrMin(max, min, dw);
                }
            } else {
                updateMaxOrMin(max, min, dw);
            }
        }

        return false;
    }

    private void updateMaxOrMin(long[] max, long[] min, List<Integer> dw) {
        int tempMax = dw.get(0);
        int tempMin = dw.get(0);

        for (int i = 1; i < dw.size(); i++) {
            int current = dw.get(i);
            if (current > tempMax) {
                tempMax = current;
            } else if (current < tempMin) {
                tempMin = current;
            }
        }
        max[0] = tempMax;
        min[0] = tempMin;
    }

    // |a - b| <= t  =>  a <= t + b || a >= b - t
    private boolean satisfy(long max, long min, int current, int t) {
        return min <= t + current || max >= current - t;
    }
}
