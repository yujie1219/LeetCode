package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fb = new ArrayList<>();
        fb.add(1);
        fb.add(1);

        int result = 0;
        while (k != 0) {
            k = findValue(fb, k);
            result++;
        }

        return result;
    }

    private int findValue(List<Integer> fb, int k) {
        for (int i = 0; i < fb.size(); i++) {
            if (fb.get(i) > k) {
                return k - fb.get(i - 1);
            }
        }

        int first = fb.get(fb.size() - 2);
        int second = fb.get(fb.size() - 1);

        int result = first + second;
        while (result <= k) {
            fb.add(result);
            first = second;
            second = result;
            result = first + second;
        }

        return k - second;
    }
}
