package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode166 {
    public static void main(String[] args) {
        new LeetCode166().fractionToDecimal(4, 333);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        if (!(numerator < 0 && denominator < 0) && !(numerator > 0 && denominator > 0)) {
            builder.append("-");
        }

        long absNumerator = Math.abs((long) numerator);
        long absDenominator = Math.abs((long)denominator);

        long quotient = absNumerator / absDenominator;
        builder.append(quotient);

        long remainder = absNumerator % absDenominator;
        if (remainder == 0) {
            return builder.toString();
        }

        builder.append(".");
        Map<Long, Long> remainder2Quotient = new HashMap<>();
        List<Long> keys = new ArrayList<>();

        while (!remainder2Quotient.containsKey(remainder) && remainder != 0) {
            quotient = (remainder * 10) / absDenominator;
            remainder2Quotient.put(remainder, quotient);
            keys.add(remainder);
            remainder = (remainder * 10) % absDenominator;
        }

        boolean addLeft = false;
        for (Long key : keys) {
            if (remainder != 0 && key == remainder && !addLeft) {
                builder.append("(");
                builder.append(remainder2Quotient.get(key));
                addLeft = true;
            } else {
                builder.append(remainder2Quotient.get(key));
            }
        }

        if (addLeft) {
            builder.append(")");
        }
        return builder.toString();
    }
}
