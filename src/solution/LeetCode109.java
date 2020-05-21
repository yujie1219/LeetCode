package solution;

import model.ListNode;
import model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode109 {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> listNode = listNodeToList(head);

        return generateTree(listNode, 0, listNode.size() - 1);
    }

    private List<Integer> listNodeToList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }


    private TreeNode generateTree(List<Integer> listNode, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(listNode.get(start));
        }

        int mid = (start + end) / 2;
        TreeNode current = new TreeNode(listNode.get(mid));

        current.left = generateTree(listNode, start, mid - 1);
        current.right = generateTree(listNode, mid + 1, end);

        return current;
    }

}
