package solution;

import model.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode817 {
    public static void main(){

    }

    public int numComponents(ListNode head, int[] G) {
        List<List<Integer>> tempResults = new ArrayList<>();
        FindPC findPC = new FindPC(head);

        for (Integer v : G) {
            Integer parent = findPC.getParent(v);
            Integer child = findPC.getChild(v);

            Integer parentIndex = -1;
            if (parent != null) {
                parentIndex = findIndex(tempResults, parent);
            }

            Integer childIndex = -1;
            if (child != null) {
                childIndex = findIndex(tempResults, child);
            }

            if (parentIndex == -1 && childIndex == -1) {
                List<Integer> tempResult = new ArrayList<>();
                tempResult.add(v);
                tempResults.add(tempResult);
            } else {
                if (parentIndex != -1 && childIndex != -1) {
                    if (parentIndex == childIndex) {
                        tempResults.get(parentIndex).add(v);
                    } else {
                        tempResults.get(parentIndex).add(v);
                        tempResults.get(parentIndex).addAll(tempResults.get(childIndex));
                        tempResults.remove(tempResults.get(childIndex));
                    }
                } else {
                    if (parentIndex != -1) {
                        tempResults.get(parentIndex).add(v);
                    } else {
                        tempResults.get(childIndex).add(v);
                    }
                }
            }
        }

        return tempResults.size();
    }

    private Integer findIndex(List<List<Integer>> tempResults, Integer v) {
        for (int i = 0; i < tempResults.size(); i++) {
            if (tempResults.get(i).contains(v)) {
                return i;
            }
        }

        return -1;
    }

    private class FindPC {
        private Map<Integer, Integer> parents = new HashMap<>();
        private Map<Integer, Integer> children = new HashMap<>();

        public FindPC(ListNode head) {
            ListNode parent = null;
            ListNode current = head;
            ListNode child;

            while (current != null) {
                child = current.next;
                if (parent != null) {
                    parents.put(current.val, parent.val);
                }

                if (child != null) {
                    children.put(current.val, child.val);
                }

                parent = current;
                current = child;
            }
        }

        public Integer getParent(Integer v) {
            return parents.containsKey(v) ? parents.get(v) : null;
        }

        public Integer getChild(Integer v) {
            return children.containsKey(v) ? children.get(v) : null;
        }
    }
}
