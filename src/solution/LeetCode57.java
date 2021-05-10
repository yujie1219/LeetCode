package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        boolean inserted = false;

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (!inserted && current[0] > newInterval[1]) {
                doExec(result, newInterval);
                inserted = true;
            }
            result.add(current);
        }

        if (!inserted) {
            doExec(result, newInterval);
        }

        return result.toArray(new int[result.size()][2]);
    }

    private void doExec(List<int[]> result, int[] newInterval) {
        while (!result.isEmpty()) {
            int[] preview = result.get(result.size() - 1);
            if (preview[1] >= newInterval[1]) {
                if (preview[0] <= newInterval[0]) {
                    newInterval = preview;
                } else {
                    newInterval[1] = preview[1];
                }
                result.remove(result.size() - 1);
            } else {
                if (preview[1] < newInterval[0]) {
                    break;
                } else {
                    if (preview[0] <= newInterval[0]) {
                        newInterval[0] = preview[0];
                    }
                    result.remove(result.size() - 1);
                }
            }
        }

        result.add(newInterval);
    }
}
