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


    List<List<String>> results = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null) {
            return results;
        }

        for (int i = 1; i <= s.length(); i++) {
            String currentSuffix = s.substring(0, i);
            if (isPalindrome(currentSuffix)) {
                List<String> result = new ArrayList<>();
                result.add(currentSuffix);
                tryPartition(s.substring(i), result);
            }
        }

        return results;
    }

    private void tryPartition(String s, List<String> result) {
        if (s.length() == 0) {
            results.add(new ArrayList<>(result));
            return;
        }

        if (s.length() == 1) {
            result.add(s);
            results.add(new ArrayList<>(result));
            result.remove(result.size() - 1);
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String currentSuffix = s.substring(0, i);
            if (isPalindrome(currentSuffix)) {
                result.add(currentSuffix);
                tryPartition(s.substring(i), result);
                result.remove(result.size() - 1);
            }
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
