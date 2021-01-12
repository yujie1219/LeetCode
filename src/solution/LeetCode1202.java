package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, List<Integer>> relationShip = getRelationship(pairs);
        char[] sArr = s.toCharArray();
        int startIndex = 0;
        int currentSmallest = currentSmallest(sArr, startIndex);
    }

    

    private int currentSmallest(char[] sArr, int startIndex) {
        int result = startIndex;
        for (int i = startIndex + 1; i < sArr.length; i++) {
            if (sArr[result] > sArr[i]) {
                result = i;
            }
        }

        return result;
    }

    private Map<Integer, List<Integer>> getRelationship(List<List<Integer>> pairs) {
        Map<Integer, List<Integer>> relationShip = new HashMap<>();
        for (List<Integer> pair : pairs) {
            Integer key = pair.get(0);
            if (!relationShip.containsKey(key)) {
                relationShip.put(key, new ArrayList<>());
            }

            relationShip.get(key).add(pair.get(1));
        }

        return relationShip;
    }
}
