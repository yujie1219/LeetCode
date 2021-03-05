package solution;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int alreadySatify = init(customers, grumpy);

        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }

        int maxIncrease = increase;
        for (int i = X; i < grumpy.length; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(increase, maxIncrease);
        }

        return alreadySatify + increase;
    }

//    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
//        int alreadySatify = init(customers, grumpy);
//
//        int result = alreadySatify;
//        for (int i = 0; i < grumpy.length; i++) {
//            if (grumpy[i] == 1) {
//                int temp = getResult(customers, grumpy, i, i + X, alreadySatify);
//                result = temp > result ? temp : result;
//
//                if (i + X > grumpy.length) {
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }

    private int init(int[] customers, int[] grumpy) {
        int result = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }

        return result;
    }

//    private int getResult(int[] customers, int[] grumpy, int start, int end, int alreadySatify) {
//        end = end > grumpy.length ? grumpy.length : end;
//        for (int i = start; i < end; i++) {
//            if (grumpy[i] == 1) {
//                alreadySatify += customers[i];
//            }
//        }
//
//        return alreadySatify;
//    }
}
