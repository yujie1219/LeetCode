package solution;

import model.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode406 {
    public static void main(String[] args) {
        new LeetCode406().reconstructQueue(new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}});
    }

    public int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<Integer>> position2Height = new HashMap<>();

        for (int i = 0; i < people.length; i++) {
            int position = people[i][1];
            if (!position2Height.containsKey(position)) {
                position2Height.put(position, new ArrayList<>());
            }

            position2Height.get(position).add(people[i][0]);
        }

        ListNode head = new ListNode();

        List<Integer> keySet = position2Height.keySet().stream().sorted().collect(Collectors.toList());

        for (int key : keySet) {
            List<Integer> heights = position2Height.get(key);

            if (key == 0) {
                Collections.sort(heights);
                for (int i = 0; i < heights.size(); i++) {
                    ListNode temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }

                    temp.next = new ListNode(heights.get(i), key);
                }
            } else {
                Collections.sort(heights, Collections.reverseOrder());
                for (int i = 0; i < heights.size(); i++) {
                    int position = key;
                    ListNode temp = head.next;
                    while (temp.next != null && position != 0) {
                        if (temp.height >= heights.get(i)) {
                            position--;
                        }

                        if (position == 0) {
                            break;
                        }
                        temp = temp.next;
                    }

                    ListNode foo = temp.next;
                    temp.next = new ListNode(heights.get(i), key);
                    temp.next.next = foo;
                }
            }
        }

        int[][] result = new int[people.length][2];
        head = head.next;
        int i = 0;
        while (head != null) {
            result[i] = new int[]{head.height, head.position};
            i++;
            head = head.next;
        }

        return result;

    }
}
