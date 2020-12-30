package solution;

import java.util.*;

public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> charges = new HashMap<>();
        charges.put(5, 0);
        charges.put(10, 0);
        charges.put(20, 0);

        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    charges.put(5, charges.get(5).intValue() + 1);
                    break;
                case 10:
                    if (charges.get(5).intValue() > 0) {
                        charges.put(5, charges.get(5).intValue() - 1);
                        charges.put(10, charges.get(10).intValue() + 1);
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (charges.get(10).intValue() > 0) {
                        if (charges.get(5).intValue() > 0) {
                            charges.put(5, charges.get(5).intValue() - 1);
                            charges.put(10, charges.get(10).intValue() - 1);
                            charges.put(20, charges.get(20).intValue() + 1);
                        } else {
                            return false;
                        }
                    } else {
                        if (charges.get(5).intValue() >= 3) {
                            charges.put(5, charges.get(5).intValue() - 3);
                            charges.put(20, charges.get(20).intValue() + 1);
                        } else {
                            return false;
                        }
                    }
                    break;
            }
        }

        return true;
    }
}
