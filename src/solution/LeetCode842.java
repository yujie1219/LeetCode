package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode842 {
    public static void main(String[] args) {
        new LeetCode842().splitIntoFibonacci("123456789");
    }

    public List<Integer> splitIntoFibonacci(String S) {
        String[] array = S.split("");
        List<Integer> result = null;

        int maxLength = array.length - 2;
        for (int i = 1; i <= maxLength; i++) {
            boolean getResult = false;
            for (int j = 1; j <= i; j++) {
                if (array.length - 1 - i < 0) {
                    break;
                }
                result = new ArrayList<>();
                result.add((int) (double) getNum(array, array.length - 1, i));
                result.add((int) (double) getNum(array, array.length - 1 - i, j));
                if (getResult = findFibonacci(array, array.length - 1, i, array.length - 1 - i, j, result)) {
                    break;
                }
            }

            if (getResult) {
                break;
            }
        }
        Collections.reverse(result);
        return result;
    }

    private boolean findFibonacci(String[] array, int index, int length, int index2, int length2, List<Integer> result) {
        if (length + length2 >= array.length) {
            return false;
        }

        int remainLength = array.length - length - length2;
        int tryLength = remainLength > length ? length : remainLength;
        for (int i = 1; i <= tryLength; i++) {
            if (index2 - length2 - i + 1 < 0) {
                break;
            }
            double sum = getNum(array, index, length);
            double addNum2 = getNum(array, index2, length2);
            if (sum - addNum2 == getNum(array, index2 - length2, i)) {
                if (remainLength == i) {
                    result.add((int) (sum - addNum2));
                    return true;
                } else {
                    return findFibonacci(array, index2, length2, index2 - length2, i, result);
                }
            }
        }

        return false;
    }

    private Double getNum(String[] array, int index, int length) {
        double sum = 0;
        for (int i = 1; i <= length; i++) {
            sum += Integer.parseInt(array[index]) * Math.pow(10, i - 1);
            index--;
        }

        return sum;
    }
}
