package solution;

import java.util.*;

public class LeetCode318 {
    public static void main(String[] args) {
        System.out.println(new LeetCode318().maxProduct(new String[]{"1", "22", "33"}));
    }

    public int maxProduct(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        Set<Character> used = new HashSet<>();
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            this.fillUsed(used, word);

            for (int j = i + 1; j < words.length; i++) {
                if (!contains(used, words[j])) {
                    int length = word.length() * words[j].length();
                    result = Math.max(length, result);
                    break;
                }
            }

            used.clear();
        }

        return result;
    }

    private void fillUsed(Set<Character> used, String s) {
        for (Character ch : s.toCharArray()) {
            used.add(ch);
        }
    }

    private boolean contains(Set<Character> used, String s) {
        for (Character ch : s.toCharArray()) {
            if (used.contains(ch)) {
                return true;
            }
        }

        return false;
    }
}
