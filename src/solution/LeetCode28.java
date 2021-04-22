package solution;

public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int i = 0;
        int ni = 0;
        int hi = 0;
        while (i < haystack.length() - needle.length()) {
            hi = i;

            while (ni < needle.length() && haystack.charAt(hi) == needle.charAt(ni)) {
                ni++;
                hi++;
            }

            if (ni == needle.length()) {
                return i;
            } else {
                ni = 0;
                i++;
            }
        }

        return -1;
    }
}
