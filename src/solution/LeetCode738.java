package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode738 {
    public int monotoneIncreasingDigits(int N) {
        String[] ns = (N + "").split("");
        if (satifyRule(ns)) {
            return N;
        }

        return Integer.parseInt(findNum(ns, 0));
    }

    private String findNum(String[] ns, int start) {
        if (start >= ns.length) {
            return "";
        }

        String current = "";
        String target = "";
        for (int i = start; i < ns.length; i++) {
            current = current + ns[start];
            target = target + ns[i];
        }

        if (Integer.parseInt(current) > Integer.parseInt(target)) {
            String result = "";
            if (!ns[start].equals("1")) {
                result = (Integer.parseInt(ns[start]) - 1) + "";
            }

            for (int i = start + 1; i < ns.length; i++) {
                result += "9";
            }

            return result;
        } else {
            return Integer.parseInt(ns[start]) + findNum(ns, start + 1);
        }
    }

    private boolean satifyRule(String[] ns) {
        for (int i = 0; i < ns.length - 1; i++) {
            if (Integer.parseInt(ns[i]) > Integer.parseInt(ns[i + 1])) {
                return false;
            }
        }

        return true;
    }
}
