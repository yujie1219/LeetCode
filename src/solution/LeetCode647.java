package solution;

public class LeetCode647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int length = 1; length < s.length() - i + 1; length++) {
                if (isSubstrings(s.substring(i, i + length))) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isSubstrings(String s) {
        if (s.length() == 1) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
