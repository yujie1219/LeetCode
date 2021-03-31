package solution;

import model.NestedInteger;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode341 {
    public class NestedIterator implements Iterator<Integer> {
        private Deque<Integer> deque;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.deque = new LinkedList<>();
            parseNestedList(nestedList);
        }

        @Override
        public Integer next() {
            return deque.pollFirst();
        }

        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }

        private void parseNestedList(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    this.deque.addLast(nestedInteger.getInteger());
                } else {
                    parseNestedList(nestedInteger.getList());
                }
            }
        }
    }
}
