package solution;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode823 {
    public static void main(String[] args) {
        new LeetCode823().numFactoredBinaryTrees(new int[]{46, 144, 5040, 4488, 544, 380, 4410, 34, 11, 5, 3063808, 5550, 34496, 12, 540, 28, 18, 13, 2, 1056, 32710656, 31, 91872, 23, 26, 240, 18720, 33, 49, 4, 38, 37, 1457, 3, 799, 557568, 32, 1400, 47, 10, 20774, 1296, 9, 21, 92928, 8704, 29, 2162, 22, 1883700, 49588, 1078, 36, 44, 352, 546, 19, 523370496, 476, 24, 6000, 42, 30, 8, 16262400, 61600, 41, 24150, 1968, 7056, 7, 35, 16, 87, 20, 2730, 11616, 10912, 690, 150, 25, 6, 14, 1689120, 43, 3128, 27, 197472, 45, 15, 585, 21645, 39, 40, 2205, 17, 48, 136});
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        Integer[] sorted = sort(arr);
        Map<Integer, Long> number2Result = new HashMap<>();
        number2Result.put(sorted[0], 1L);
        List<Integer> looped = new ArrayList<>();
        looped.add(sorted[0]);

        for (int i = 1; i < sorted.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (sorted[i] % sorted[j] == 0) {
                    int result = sorted[i] / sorted[j];
                    if (looped.contains(result)) {
                        if (number2Result.containsKey(sorted[i])) {
                            number2Result.put(sorted[i], (number2Result.get(sorted[i]) + (number2Result.get(sorted[j]) * number2Result.get(result))) % MOD);
                        } else {
                            number2Result.put(sorted[i], (number2Result.get(sorted[j]) * number2Result.get(result)) % MOD);
                        }
                    }
                }
            }

            if (number2Result.containsKey(sorted[i])) {
                number2Result.put(sorted[i], number2Result.get(sorted[i]) + 1);
            } else {
                number2Result.put(sorted[i], 1L);
            }

            looped.add(sorted[i]);
        }

        Long result = 0L;
        for (Long sum : number2Result.values()) {
            result += sum;
        }

        return (int) (result % MOD);
    }

    private Integer[] sort(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> x - y);

        for (int a : arr) {
            priorityQueue.add(a);
        }

        Integer[] result = new Integer[arr.length];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            result[i] = priorityQueue.poll();
            i++;
        }

        return result;
    }
}
