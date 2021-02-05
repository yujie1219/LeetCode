package solution;

import java.util.Map;

public class LeetCode1208 {
    public static void main(String[] args) {
        new LeetCode1208().equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int currentCost = 0;
        int start = 0;
        int end = 0;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int result = 0;

        while (end < s.length()) {
            int discrepancy = Math.abs(sArr[end] - tArr[end]);
            if (discrepancy > maxCost) {
                int temp = end - start;
                if (temp > result) {
                    result = temp;
                }
                start = ++end;
                currentCost = 0;
            } else {
                if (currentCost + discrepancy <= maxCost) {
                    end++;
                    currentCost += discrepancy;
                } else {
                    int temp = end - start;
                    if (temp > result) {
                        result = temp;
                    }
                    currentCost -= Math.abs(sArr[start] - tArr[start]);
                    start++;
                }
            }
        }

        int temp = end - start;
        if (temp > result) {
            result = temp;
        }

        return result;
    }
}
