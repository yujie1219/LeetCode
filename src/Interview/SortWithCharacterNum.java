package Interview;

import java.util.*;

public class SortWithCharacterNum {
    public static void main(String[] args) {
        SortWithCharacterNum sort = new SortWithCharacterNum();

        System.out.println(sort.sort("123123412345"));
        System.out.println(sort.sort("12345"));
        System.out.println(sort.sort("321211554"));
        System.out.println(sort.sort("32121257524"));
        System.out.println(sort.sort("321a2#12#a2ba4"));
        System.out.println(sort.sort("333221"));
        System.out.println(sort.sort("122333"));
        System.out.println(sort.sort("33322122333"));
        System.out.println(sort.sort("试面试天俞俞天杰今天"));
    }

    public String sort(String input) {
        if (input == null) {
            return null;
        }

        List<String> keySorted = new ArrayList<>();
        Map<String, Integer> value2Num = new HashMap<>();
        String[] inputArr = input.split("");

        for (String e : inputArr) {
            if (!keySorted.contains(e)) {
                keySorted.add(e);
            }

            if (!value2Num.containsKey(e)) {
                value2Num.put(e, 0);
            }
            value2Num.put(e, value2Num.get(e) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        List<String> used = new ArrayList<>();

        while (used.size() != keySorted.size()) {
            String currentKey = findMost(used, value2Num, keySorted);
            for (int i = 1; i <= value2Num.get(currentKey); i++) {
                stringBuilder.append(currentKey);
            }
        }

        return stringBuilder.toString();
    }

    private String findMost(List<String> used, Map<String, Integer> value2Num, List<String> keySorted) {
        String result = null;
        int most = 0;

        for (String key : keySorted) {
            if (!used.contains(key)) {
                int currentNum = value2Num.get(key);
                if (currentNum > most) {
                    most = currentNum;
                    result = key;
                }
            }
        }

        used.add(result);
        return result;
    }


}
