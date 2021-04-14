package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        int[] letterOccurNum = new int[26];
        List<Character> usedLetter = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            letterOccurNum[s.charAt(i) - 'a'] += 1;
        }

        Deque<Character> dequeue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (usedLetter.contains(current)) {
                letterOccurNum[current - 'a'] -= 1;
                continue;
            }

            while (!dequeue.isEmpty()) {
                if (dequeue.peekLast() > current) {
                    if (letterOccurNum[dequeue.peekLast() - 'a'] != 0) {
                        Character moved = dequeue.pollLast();
                        usedLetter.remove(moved);
                    } else {
                        break;
                    }
                } else if (dequeue.peekLast() < current) {
                    break;
                }
            }

            dequeue.addLast(current);
            letterOccurNum[current - 'a'] -= 1;
            usedLetter.add(current);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!dequeue.isEmpty()) {
            stringBuilder.append(dequeue.pollFirst());
        }

        return stringBuilder.toString();
    }
}
