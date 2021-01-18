package solution;

import java.util.*;

public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {

        String[] rules = pattern.split("");
        String[] sArr = s.split(" ");
        if (rules.length != sArr.length)
            return false;

        Map<String, List<Integer>> rule = getRule(rules);

        List<String> differentLocal = new ArrayList<>();
        for (List<Integer> indexs : rule.values()) {
            String current = sArr[indexs.get(0)];
            if (differentLocal.contains(current)) {
                return false;
            }

            for (Integer index : indexs) {
                if (!current.equals(sArr[index])) {
                    return false;
                }
            }

            differentLocal.add(current);
        }

        return true;
    }

    private Map<String, List<Integer>> getRule(String[] rules) {
        Map<String, List<Integer>> rule = new HashMap<>();

        for (int i = 0; i < rules.length; i++) {
            String e = rules[i];
            if (!rule.containsKey(e)) {
                rule.put(e, new ArrayList<>());
            }
            rule.get(e).add(i);
        }
        return rule;
    }
}
