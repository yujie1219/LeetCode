package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode526 {
    public int countArrangement(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(0);
        }

        return countArrangement(n, stringBuilder.toString(), new HashMap<>(), 1);
    }

    private int countArrangement(int n, String used, Map<String, Integer> used2Num, int currentI) {
        if (currentI == n + 1) {
            return 1;
        }

        if (used2Num.containsKey(used)) {
            return used2Num.get(used);
        }

        StringBuilder stringBuilder = new StringBuilder(used);
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (stringBuilder.charAt(i - 1) != '1' && (i % currentI == 0 || currentI % i == 0)) {
                stringBuilder.setCharAt(i - 1, '1');
                num += countArrangement(n, stringBuilder.toString(), used2Num, currentI + 1);
                stringBuilder.setCharAt(i - 1, '0');
            }
        }

        return num;
    }
}
