package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class LeetCode387 {
    public int firstUniqChar(String s) {
        if(s.length() == 0){
            return -1;
        }

        Map<Character, List<Integer>> parse = new HashMap<>();

        int index = 0;
        for (char c : s.toCharArray()) {
            if (!parse.containsKey(c)) {
                parse.put(c, new ArrayList<>());
            }

            parse.get(c).add(index++);
        }

        int result = Integer.MAX_VALUE;
        for (Character c : parse.keySet()) {
            if (parse.get(c).size() == 1) {
                result = Math.min(result, parse.get(c).get(0));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
