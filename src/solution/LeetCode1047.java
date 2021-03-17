package solution;

public class LeetCode1047 {
    public String removeDuplicates(String S) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            Character current = S.charAt(i);
            if (stringBuilder.length() == 0) {
                stringBuilder.append(current);
            } else {
                if (stringBuilder.charAt(stringBuilder.length() - 1) == current) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    stringBuilder.append(current);
                }
            }
        }

        return stringBuilder.toString();
    }
}
