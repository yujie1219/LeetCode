package solution;

import java.util.Map;
import java.util.TreeMap;

public class LeetCode274 {
    public int hIndex(int[] citations) {
        Map<Integer, Integer> countMap = new TreeMap<>((a, b) -> {
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            } else {
                return 0;
            }
        });

        for (int i = 0; i < citations.length; i++) {
            if (!countMap.containsKey(citations[i])) {
                countMap.put(citations[i], 1);
            } else {
                countMap.put(citations[i], countMap.get(citations[i]) + 1);
            }
        }

        Integer maxRead = (Integer) countMap.keySet().toArray()[0];
        int currentNum = 0;
        while (maxRead >= 0) {
            if (countMap.containsKey(maxRead)) {
                currentNum += countMap.get(maxRead);
            }

            if (currentNum >= maxRead) {
                return maxRead;
            }

            maxRead--;
        }

        return maxRead;
    }
}
