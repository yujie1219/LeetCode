package solution;

import model.RandomNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode138 {

    private HashMap<RandomNode, RandomNode> copiedNode = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }

        RandomNode copied = copiedNode.get(head);
        if (copied != null) {
            return copied;
        } else {
            RandomNode current = new RandomNode(head.val);
            copiedNode.put(head, current);

            current.next = copyRandomList(head.next);
            current.random = copyRandomList(head.random);

            return current;
        }
    }
}
