package solution;

import java.util.PriorityQueue;

public class LeetCode179Re {
    public static void main(String[] args) {
        new LeetCode179Re().largestNumber(new int[]{3, 30});
    }

    public String largestNumber(int[] nums) {
        // 返回负数说明a >b, 正数b>a， 0 代表相等
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>((String a, String b) -> {
            String ab = a + b;
            String ba = b + a;

            int i = 0;
            while (i < ab.length()) {
                int abCurrent = Integer.parseInt(String.valueOf(ab.charAt(i)));
                int baCurrent = Integer.parseInt(String.valueOf(ba.charAt(i)));

                if (abCurrent > baCurrent) {
                    return -1;
                } else if (abCurrent < baCurrent) {
                    return 1;
                }

                i++;
            }

            return 0;
        });

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i] + "");
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            if (stringBuilder.length() == 0 && priorityQueue.peek().equals("0")) {
                priorityQueue.poll();
            } else {
                stringBuilder.append(priorityQueue.poll());
            }
        }

        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
