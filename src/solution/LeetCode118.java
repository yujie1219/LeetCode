package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows != 0) {
            for (int i = 0; i < numRows; i++) {
                if (i == 0) {
                    result.add(generate(null, i + 1));
                } else {
                    result.add(generate(result.get(i), i + 1));
                }
            }
        }

        return result;
    }

    private List<Integer> generate(List<Integer> last, int length) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (last != null) {
            for (int i = 1; i < length - 1; i++) {
                result.add(last.get(i - 1) + last.get(i));
            }

            result.add(1);
        }

        return result;
    }
}
