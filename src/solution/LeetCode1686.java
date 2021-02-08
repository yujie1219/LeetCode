package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[] truthValue = new int[aliceValues.length];
        for (int i = 0; i < aliceValues.length; i++) {
            truthValue[i] = aliceValues[i] + bobValues[i];
        }

        List<Integer> picked = new ArrayList<>();
        int alice = 0;
        int bob = 0;
        while (picked.size() != aliceValues.length) {

            alice += aliceValues[decideWhichToPick(truthValue, picked)];

            if (picked.size() != aliceValues.length) {
                bob += bobValues[decideWhichToPick(truthValue, picked)];
            }
        }

        if (alice > bob) {
            return 1;
        } else if (alice == bob) {
            return 0;
        } else {
            return -1;
        }
    }

    private int decideWhichToPick(int[] truthValue, List<Integer> picked) {
        int pick = -1;
        int currentPicked = Integer.MIN_VALUE;

        for (int i = 0; i < truthValue.length; i++) {
            if (!picked.contains(i) && truthValue[i] > currentPicked) {
                currentPicked = truthValue[i];
                pick = i;
            }
        }

        picked.add(pick);
        return pick;
    }
}
