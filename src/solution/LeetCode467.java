package solution;

import java.util.Arrays;

public class LeetCode467 {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) {
            return 0;
        }

        int[] foo = new int[26];
        foo[p.charAt(0) - 'a'] = 1;

        for (int i = 1; i < p.length(); i++) {
            char current = p.charAt(i);
            char prev = p.charAt(i - 1);
            int length = 1;
            while ((current != 'a' && current - 1 == prev) || (current == 'a' && prev == 'z')) {
                length++;
                foo[current - 'a'] = Math.max(foo[current - 'a'], length);

                if (i == p.length() - 1) {
                    break;
                }

                current = p.charAt(++i);
                prev = p.charAt(i - 1);
            }

            foo[current - 'a'] = Math.max(foo[current - 'a'], 1);
        }

        return Arrays.stream(foo).sum();
    }
}
