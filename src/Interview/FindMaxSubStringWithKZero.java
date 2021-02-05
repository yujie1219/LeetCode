package Interview;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxSubStringWithKZero {

    public int maxLength(int[] nums, int k) {
        int zeroNum = 0;
        Queue<Integer> zeroIndexQueue = new LinkedList<>();

        int index = 0;
        int start = 0;
        int result = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                if (zeroNum < k) {
                    zeroIndexQueue.offer(index);
                    zeroNum++;
                } else {
                    int currentLength = index - start;
                    if (currentLength > result) {
                        result = currentLength;
                    }

                    start = zeroIndexQueue.poll() + 1;
                    zeroIndexQueue.offer(index);
                }
            }
            index++;
        }

        int currentLength = nums.length - 1 - start;
        if (currentLength > result) {
            result = currentLength;
        }

        return result;
    }
}
