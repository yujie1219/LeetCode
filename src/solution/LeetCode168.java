package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode168 {

    private Integer A = 65;

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();

        int length = 1;
        while (n > Math.pow(26, length) + 25) {
            length++;
        }

        length = length - 1;
        double dn = n;
        while (dn > 26) {
            builder.append(Character.toString((char) (A + (dn / Math.pow(26, length)) - 1)));

            dn = dn % Math.pow(26, length);
            length--;
        }

        builder.append(Character.toString((char) (A + dn - 1)));

        return builder.toString();
    }
}
