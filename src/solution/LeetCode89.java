package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);

        int[] grayCode = new int[n];
        parseGrayCode(grayCode, result, 0);

        return result;
    }

    private void parseGrayCode(int[] grayCode, List<Integer> result, int startIndex) {
        for (int i = startIndex; i < grayCode.length; i++) {
            grayCode[i] = 1;

            result.add(getValue(grayCode));
            parseGrayCode(grayCode, result, i + 1);
            grayCode[i] = 0;
        }
    }

    private int getValue(int[] grayCode) {
        int result = 0;

        for (int i = 0; i < grayCode.length; i++) {
            result += grayCode[i] * Math.pow(2, grayCode.length - 1 - i);
        }

        return result;
    }
}
