package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> originMap = new HashMap<>();
        for (char e : s.toCharArray()) {
            originMap.put(e, originMap.containsKey(e) ? originMap.get(e) + 1 : 1);
        }

        for (char e : t.toCharArray()) {
            if (!originMap.containsKey(e)) {
                return e;
            } else {
                Integer count = originMap.get(e);
                if (count == 0) {
                    return e;
                }
                originMap.put(e, --count);
            }
        }

        return 'a';
    }
}
