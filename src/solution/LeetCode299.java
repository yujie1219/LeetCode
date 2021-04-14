package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode299 {
    public String getHint(String secret, String guess) {
        String[] secretArr = secret.split("");
        String[] guessArr = guess.split("");
        Map<String, Integer> numCount = new HashMap<>();

        for (String element : secretArr) {
            if (!numCount.containsKey(element)) {
                numCount.put(element, 0);
            }

            numCount.put(element, numCount.get(element) + 1);
        }

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guessArr.length; i++) {
            String current = guessArr[i];
            if (current.equals(secretArr[i])) {
                if (numCount.get(current) > 0) {
                    bulls++;
                    numCount.put(current, numCount.get(current) - 1);
                } else {
                    cows--;
                    bulls++;
                }
            } else {
                if (numCount.containsKey(current) && numCount.get(current) > 0) {
                    cows++;
                    numCount.put(current, numCount.get(current) - 1);
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}
