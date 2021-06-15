package solution;

import java.util.Arrays;
import java.util.List;

public class LeetCode539 {
    public static void main(String[] args) {
        new LeetCode539().findMinDifference(Arrays.asList("23:59", "00:00"));
    }

    public int findMinDifference(List<String> timePoints) {
        timePoints.sort((a, b) -> getMinus(a, b, true, false));

        int i = 0;
        int j = 1;

        int result = Integer.MAX_VALUE;
        while (j < timePoints.size()) {
            result = Math.min(result, getMinus(timePoints.get(j), timePoints.get(i), false, false));
            if (result == 0) {
                break;
            }

            i++;
            j++;
        }

        result = Math.min(result, getMinus(timePoints.get(i), timePoints.get(0), false, true));
        return result;
    }

    private int getMinus(String a, String b, boolean sort, boolean last) {
        String[] aSp = a.split(":");
        String[] bSp = b.split(":");

        int aH = Integer.parseInt(aSp[0]);
        int bH = Integer.parseInt(bSp[0]);
        if (aH != bH) {
            if (sort) {
                return aH - bH;
            } else {
                int aMin = Integer.parseInt(aSp[1]);
                int bMin = Integer.parseInt(bSp[1]);
                int result = (aH * 60 + aMin) - (bH * 60 + bMin);
                if (last) {
                    result = Math.min(result, ((bH + 24) * 60 + bMin) - (aH * 60 + aMin));
                }

                return result;
            }
        } else {
            int aMin = Integer.parseInt(aSp[1]);
            int bMin = Integer.parseInt(bSp[1]);
            return aMin - bMin;
        }
    }
}
