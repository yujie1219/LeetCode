package solution;

public class LeetCode43Re {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String result = new String();
        for (int i = 0; i < num1.length(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int k = 0; k < i; k++) {
                temp.append(0);
            }

            int jinWei = 0;
            int j = 0;
            while (j < num2.length()) {
                Integer value = (num1.charAt(num1.length() - 1 - i) - '0') * (num2.charAt(num2.length() - 1 - j) - '0') + jinWei;
                temp.append(value % 10);
                jinWei = value / 10;
                j++;
            }

            if (jinWei != 0) {
                temp.append(jinWei % 10);
            }

            result = stringAdd(result, temp.reverse().toString());
        }

        return result;
    }

    public String stringAdd(String s1, String s2) {
        int i = 0;
        int jinWei = 0;
        StringBuilder result = new StringBuilder();
        int length1 = s1.length();
        int length2 = s2.length();

        while (i < length1 || i < length2 || jinWei != 0) {
            Integer num1 = i < length1 ? s1.charAt(s1.length() - 1 - i) - '0' : 0;
            Integer num2 = i < length2 ? s2.charAt(s2.length() - 1 - i) - '0' : 0;

            Integer value = num1 + num2 + jinWei;
            result.append(value % 10);
            jinWei = value / 10;
            i++;
        }

        return result.reverse().toString();
    }
}
