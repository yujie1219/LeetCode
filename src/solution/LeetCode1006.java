package solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode1006 {
    public static void main(String[] args) {
        new LeetCode1006().clumsy(4);
    }

    public int clumsy(int N) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> operations = new LinkedList<>();

        char[] opers = new char[4];
        opers[0] = '*';
        opers[1] = '/';
        opers[2] = '+';
        opers[3] = '-';

        int j = 0;
        for (int i = N; i >= 1; i--) {
            if (!operations.isEmpty()) {
                if (operations.peekLast() == '*') {
                    nums.offerLast(nums.pollLast() * i);
                    operations.pollLast();
                } else if (operations.peekLast() == '/') {
                    nums.offerLast(nums.pollLast() / i);
                    operations.pollLast();
                } else {
                    nums.offerLast(i);
                }
            } else {
                nums.offerLast(i);
            }

            operations.offerLast(opers[j % 4]);
            j++;
        }

        operations.pollLast();

        int num = nums.pollFirst();
        while (!operations.isEmpty()) {
            char oper = operations.pollFirst();
            if (oper == '+') {
                num = num + nums.pollFirst();
            } else {
                num = num - nums.pollFirst();
            }
        }

        return num;
    }
}
