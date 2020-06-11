package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode131 {
    public static void main(String[] args) {
        LeetCode131 leetCode131 = new LeetCode131();

        leetCode131.partition("aab");
    }

    private Set<String> knownPalindrome = new HashSet<>();
    private List<List<String>> results = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null) {
            return results;
        }

        tryPartition(s, 0, 0, new ArrayList<>());

        return results;
    }

    private void tryPartition(String s, int index, int length, List<String> result) {
        if (index > s.length() || (length != 0 && index + length >= s.length())) {
            return;
        }

        if (index == s.length()) {
            results.add(new ArrayList<>(result));
            return;
        }

        if (length == 0) {
            String indexS = s.charAt(index) + "";
            knownPalindrome.add(indexS);
            result.add(indexS);
            tryPartition(s, index + 1, length, result);
            result.remove(indexS);
            tryPartition(s, index, length + 1, result);
        } else {
            String currentS = s.substring(index, index + length + 1);
            if (knownPalindrome.contains(currentS) || isPalindrome(currentS)) {
                knownPalindrome.add(currentS);
                result.add(currentS);
                tryPartition(s, index + length + 1, 0, result);
                result.remove(currentS);
            }
            tryPartition(s, index, length + 1, result);
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
