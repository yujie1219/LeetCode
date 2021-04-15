package solution;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class LeetCodeInterview1721 {
    public static void main(String[] args) {
        new LeetCodeInterview1721().trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6});
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                if (height[i] != 0) {
                    stack.push(i);
                }
            } else {
                if (height[i] >= height[stack.peek()]) {
                    int needReduce = 0;
                    int lastBorder = -1;

                    while (!stack.isEmpty() && (lastBorder == -1 ? true : height[lastBorder] < height[i])) {
                        if (lastBorder != -1) {
                            needReduce += height[lastBorder];
                        }

                        lastBorder = stack.pop();
                        if (map.containsKey(lastBorder)) {
                            needReduce += map.get(lastBorder);
                            map.remove(lastBorder);
                        }
                    }

                    boolean useStack = false;
                    if (height[lastBorder] > height[i]) {
                        useStack = true;
                        stack.push(lastBorder);
                    }

                    int border = Math.min(height[lastBorder], height[i]);
                    int value = border * (i - lastBorder - 1) - needReduce;
                    result = value > 0 ? result + value : result;

                    if (!stack.isEmpty()) {
                        if (!map.containsKey(stack.peek())) {
                            map.put(stack.peek(), 0);
                        }
                        map.put(stack.peek(), value + needReduce + (useStack ? 0 : height[lastBorder]) + map.get(stack.peek()));
                    }
                }
                stack.push(i);
            }
        }

        return result;
    }
}
