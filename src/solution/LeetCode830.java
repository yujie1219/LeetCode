package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode830 {
    public static void main(String[] args) {
        new LeetCode830().largeGroupPositions("abcdddeeeeaabbbcd");
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        String[] sArr = s.split("");
        String current = sArr[0];
        Integer length = 1;

        Integer index = 1;
        List<List<Integer>> result = new ArrayList<>();
        while (index < sArr.length) {
            if (!current.equals(sArr[index])) {
                if (length >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(index - length);
                    list.add(index - 1);
                    result.add(list);
                }
                length = 1;
                current = sArr[index];
            } else {
                length++;
            }
            index++;
        }

        if (length != 1) {
            List<Integer> list = new ArrayList<>();
            list.add(index - length);
            list.add(index - 1);
            result.add(list);
        }

        return result;
    }
}
