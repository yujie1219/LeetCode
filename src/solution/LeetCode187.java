package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LeetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> subString2Number = new HashMap<>();
        List<String> result = new ArrayList<>();

        if (s.length() <= 10) {
            return result;
        }

        for (int i = 0; i < s.length() - 9; i++) {
            String current = s.substring(i, i + 10);
            if (!subString2Number.containsKey(current)) {
                subString2Number.put(current, 0);
            }

            subString2Number.put(current, subString2Number.get(current) + 1);
        }

        for (String key : subString2Number.keySet()) {
            if (subString2Number.get(key) > 1) {
                result.add(key);
            }
        }

        return result;
    }
}
