package solution;

import java.util.regex.Pattern;

public class LeetCode394 {
    public static void main(String[] args) {
        new LeetCode394().decodeString("10[a]2[bc]");
    }

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Pattern isNum = Pattern.compile("\\d");

        int currentNum = 0;
        int currentleft = 0;
        StringBuilder currentBlock = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (isNum.matcher(current).matches()) {
                if (currentleft == 0) {
                    if (currentNum == 0) {
                        currentNum = Integer.parseInt(current);
                    } else {
                        currentNum = currentNum * 10 + Integer.parseInt(current);
                    }
                } else {
                    currentBlock.append(current);
                }
            } else if (current.equals("[")) {
                if (currentleft != 0) {
                    currentBlock.append(current);
                }
                currentleft++;
            } else if (current.equals("]")) {
                if (--currentleft == 0) {
                    String needAdd = decodeString(currentBlock.toString());
                    while (currentNum > 0) {
                        result.append(needAdd);
                        currentNum--;
                    }
                    currentBlock = new StringBuilder();
                } else {
                    currentBlock.append(current);
                }
            } else {
                if (currentleft != 0) {
                    currentBlock.append(current);
                } else {
                    result.append(current);
                }
            }
        }

        return result.toString();
    }
}
