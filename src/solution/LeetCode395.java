package solution;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode395 {
    public static void main(String[] args) {
        new LeetCode395().longestSubstring("aaabb", 3);
    }

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        Map<Character, Integer> ch2Num = findFirstInvalidString(s, k);
        int result = 0;
        List<String> items = new ArrayList<>();
        items.add(s);


        for (Character key : ch2Num.keySet()) {
            if (ch2Num.get(key) < k) {
                items = items.stream().flatMap(item -> {
                    return Arrays.stream(item.split(key + ""));
                }).collect(Collectors.toList());
            }
        }

        if (items.size() > 0) {
            if (!items.get(0).equals(s)) {
                for (String item : items) {
                    result = Math.max(result, longestSubstring(item, k));
                }
            } else {
                result = s.length();
            }
        }

        return result;
    }

    private Map<Character, Integer> findFirstInvalidString(String s, int k) {
        Map<Character, Integer> ch2Num = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (!ch2Num.containsKey(current)) {
                ch2Num.put(current, 0);
            }

            ch2Num.put(current, ch2Num.get(current) + 1);
        }

        return ch2Num;
    }
}
