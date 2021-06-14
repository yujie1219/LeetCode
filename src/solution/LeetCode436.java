package solution;

import java.util.*;

public class LeetCode436 {
    public static void main(String[] args) {
        new LeetCode436().findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
    }

    public int[] findRightInterval(int[][] intervals) {
        List<Integer> rights = new ArrayList<>();
        Map<Integer, Integer> left2Index = new HashMap<>();
        int length = intervals.length;
        for (int i = 0; i < length; i++) {
            rights.add(intervals[i][1]);
            left2Index.put(intervals[i][0], i);
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        Map<Integer, Integer> right2Result = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int right = intervals[i][1];
            for (int j = i; j < length; j++) {
                if (intervals[j][0] >= right) {
                    right2Result.put(right, intervals[j][0]);
                    break;
                }
            }
        }

        int[] result = new int[length];
        int i = 0;
        for (int right : rights) {
            if (right2Result.containsKey(right)) {
                result[i++] = left2Index.get(right2Result.get(right));
            } else {
                result[i++] = -1;
            }
        }

        return result;
    }
}
