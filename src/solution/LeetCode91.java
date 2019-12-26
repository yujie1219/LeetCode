package solution;

import java.util.HashMap;

public class LeetCode91 {
    public static void main(String[] args) {
        LeetCode91 leetCode91 = new LeetCode91();
        System.out.println(leetCode91.numDecodings("226"));
    }

    HashMap<String, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        } else {
            return parseNum(s);
        }
    }

    private int parseNum(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() > 1) {
            String start1 = s.substring(0, 1);
            String parse1 = s.substring(1);
            Integer startInt1 = Integer.parseInt(start1);
            if (startInt1 > 2) {
                Integer result = parseNum(parse1);
                cache.put(s, result);
                return result;
            } else if (startInt1 == 0) {
                cache.put(s, 0);
                return 0;
            } else {
                String start2 = parse1.substring(0, 1);
                String parse2 = parse1.substring(1);
                Integer startInt2 = Integer.parseInt(start2);
                if (startInt1 == 1 || startInt2 < 7) {
                    Integer result = parseNum(parse1) + parseNum(parse2);
                    cache.put(s, result);
                    return result;
                } else {
                    Integer result =  parseNum(parse2);
                    cache.put(s, result);
                    return result;
                }
            }
        } else {
            if (s.equals("0")) {
                return 0;
            }
            return 1;
        }
    }
}
