package solution;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode140 {

    // timeout
    public static void main(String[] args) {
        LeetCode140 leetCode140 = new LeetCode140();
        String[] wordDict = new String[]{"cat", "cats", "and", "sand", "dog"};
        leetCode140.wordBreak("catsanddog", Arrays.stream(wordDict).collect(Collectors.toList()));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Map<Integer, Set<String>> resultMap = new HashMap<>();
        Set<String> results = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        resultMap.put(0, new HashSet<>());

        while (!queue.isEmpty()) {
            int index = queue.poll();
            Set<String> currentResults = resultMap.get(index);
            int maxLength = s.length() - index;

            for (int length = 1; length <= maxLength; length++) {
                int currentIndex = index + length;
                String subString = s.substring(index, currentIndex);
                if (wordDictSet.contains(subString)) {
                    Set<String> result = new HashSet<>();
                    if (currentResults.size() != 0) {
                        for (String currentResult : currentResults) {
                            result.add(index == 0 ? subString : currentResult + " " + subString);
                        }
                    } else {
                        result.add(subString);
                    }
                    if (currentIndex != s.length()) {
                        queue.add(currentIndex);
                        if (resultMap.containsKey(currentIndex)) {
                            resultMap.get(currentIndex).addAll(result);
                        } else {
                            resultMap.put(currentIndex, result);
                        }
                    } else {
                        results.addAll(result);
                    }
                }
            }
        }

        return results.stream().collect(Collectors.toList());
    }
}
