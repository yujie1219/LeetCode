package solution;

import java.util.Arrays;
import java.util.List;

public class LeetCode524 {
    public static void main(String[] args) {
        new LeetCode524().findLongestWord("abpcplea", Arrays.asList(new String[]{"ale", "apple", "appld", "monkey", "plea"}));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() > b.length()) {
                return 1;
            } else if (a.length() < b.length()) {
                return -1;
            } else {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) > b.charAt(i)) {
                        return -1;
                    } else if (a.charAt(i) < b.charAt(i)) {
                        return 1;
                    }
                }

                return 0;
            }
        });

        for (int i = dictionary.size() - 1; i >= 0; i--) {
            String current = dictionary.get(i);

            if (current.length() <= s.length()) {
                int j = 0;
                int k = 0;
                while (j < current.length() && k < s.length()) {
                    if (s.charAt(k) == current.charAt(j)) {
                        j++;
                    }
                    k++;
                }

                if (j == current.length()) {
                    return current;
                }
            }
        }

        return "";
    }
}
