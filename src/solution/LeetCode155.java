package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode155 {

    class MinStack {
        List<Integer> stack;
        int index;
        int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayList<>();
            index = -1;
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.add(x);
            min = Math.min(min, x);
            index++;
        }

        public void pop() {
            if (index >= 0) {
                int removed = stack.get(index);
                stack.remove(index);
                index--;

                if (removed == min) {
                    min = findMin();
                }

            }
        }

        public int top() {
            return stack.get(index);
        }

        public int getMin() {
            return min;
        }

        private int findMin() {
            if (index >= 0) {
                int i = 1;
                int min = stack.get(0);
                while (i <= index) {
                    min = Math.min(min, stack.get(i));
                    i++;
                }

                return min;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

}
