package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119 {

    // result[i][j] == result[i-1][j-1] + result[i-1][j]
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        int i = 1;
        while (i <= rowIndex) {

            int preVal = result.get(0);
            for (int j = 0; j <= i; j++) {
                int currentVal = 1;
                if (j != i) {
                    currentVal = result.get(j);
                }

                if (j != 0 && j != i) {
                    result.set(j, currentVal + preVal);
                } else if (j == i) {
                    result.add(preVal);
                }
                preVal = currentVal;
            }

            i++;
        }

        return result;
    }
}
