package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode649 {
    public static void main(String[] args) {
        new LeetCode649().predictPartyVictory("RDD");
    }

    public String predictPartyVictory(String senate) {
        int needRemoveR = 0;
        int needRemoveD = 0;
        Queue<String> queue = new LinkedList<>(Arrays.asList(senate.split("")));
        while (queue.contains("R") && queue.contains("D")) {
            String current = queue.poll();
            if (current.equals("R")) {
                if (needRemoveR == 0) {
                    needRemoveD++;
                    queue.add(current);
                } else {
                    needRemoveR--;
                }
            }

            if (current.equals("D")) {
                if (needRemoveD == 0) {
                    needRemoveR++;
                    queue.add(current);
                } else {
                    needRemoveD--;
                }
            }
        }

        return queue.peek().equals("R") ? "Radiant" : "Dire";
    }
}
