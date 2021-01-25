package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        String[] kArr = (K + "").split("");
        int k = kArr.length - 1;
        int a = A.length - 1;
        int i = 0;

        List<Integer> v = new ArrayList<>();
        if (k < a) {
            for (int j = 0; j <= a; j++) {
                v.add(A[j]);
            }
            while (k >= 0) {
                if (add(v, a - i, Integer.valueOf(kArr[k]))) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(1);
                    temp.addAll(v);
                    v = temp;
                }
                i++;
                k--;
            }
        } else {
            for (int j = 0; j <= k; j++) {
                v.add(Integer.parseInt(kArr[j]));
            }
            while (a >= 0) {
                if (add(v, k - i, A[a])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(1);
                    temp.addAll(v);
                    v = temp;
                }
                i++;
                a--;
            }
        }

        return v;
    }

    private boolean add(List<Integer> v, int index, int value) {
        if (index >= 0) {
            if (v.get(index) + value >= 10) {
                v.set(index, (v.get(index) + value) % 10);
                return add(v, index - 1, 1);
            } else {
                v.set(index, (v.get(index) + value));
                return false;
            }
        } else {
            return true;
        }
    }
}
