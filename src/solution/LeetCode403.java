package solution;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode403 {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> position = Arrays.stream(stones).boxed().collect(Collectors.toMap(e -> e, e -> e));
        int last = Arrays.stream(stones).max().getAsInt();

        return jump(position, 0, 0, last, new ArrayList<>());
    }

    private boolean jump(Map<Integer, Integer> position, int current, int length, int last, List<DoubleElement> cache) {
        if (current == last) {
            return true;
        }

        if (cache.contains(new DoubleElement(current, length))) {
            return false;
        }

        boolean canThrough = false;
        if (length > 0 && position.get(current + length - 1) != null) {
            canThrough = jump(position, current + length - 1, length - 1, last, cache);
        }

        if (!canThrough && length > 0 && position.get(current + length) != null) {
            canThrough = jump(position, current + length, length, last, cache);
        }

        if (!canThrough && length != Integer.MAX_VALUE && position.get(current + length + 1) != null) {
            canThrough = jump(position, current + length + 1, length + 1, last, cache);
        }

        if (!canThrough) {
            cache.add(new DoubleElement(current, length));
        }

        return canThrough;
    }

    private class DoubleElement {
        int current;
        int length;

        public DoubleElement(int current, int length) {
            this.current = current;
            this.length = length;
        }

        @Override
        public boolean equals(Object o) {
            DoubleElement compare = (DoubleElement) o;
            if (o != null) {
                return compare.current == this.current && compare.length == this.length;
            }

            return false;
        }
    }
}
