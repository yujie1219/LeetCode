package solution;

import model.ListNode;

public class LeetCode725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;

        ListNode current = root;
        while (current != null) {
            length++;
            current = current.next;
        }

        int elementNum = length / k;
        int addOne = length % k;

        ListNode[] result = new ListNode[k];
        current = root;
        int count = 0;
        int index = 0;
        while (current != null) {
            if (addOne > 0) {
                if(count == 0){
                    count++;
                    result[index++] = current;
                    if (count == elementNum + 1) {
                        count = 0;
                        addOne--;
                        ListNode temp = current.next;
                        current.next = null;
                        current = temp;
                    }else {
                        current = current.next;
                    }
                }else if (count < elementNum + 1) {
                    count++;
                    if (count == elementNum + 1) {
                        count = 0;
                        addOne--;
                        ListNode temp = current.next;
                        current.next = null;
                        current = temp;
                    }else {
                        current = current.next;
                    }
                }
            } else {
                if(elementNum == 0){
                    break;
                }
                if(count == 0){
                    count++;
                    result[index++] = current;
                    if (count == elementNum) {
                        count = 0;
                        addOne--;
                        ListNode temp = current.next;
                        current.next = null;
                        current = temp;
                    }else {
                        current = current.next;
                    }
                }else if (count < elementNum) {
                    count++;
                    if (count == elementNum) {
                        count = 0;
                        addOne--;
                        ListNode temp = current.next;
                        current.next = null;
                        current = temp;
                    } else {
                        current = current.next;
                    }
                }
            }
        }

        return result;
    }
}
