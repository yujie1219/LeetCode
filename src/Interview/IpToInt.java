package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class IpToInt {

    public static void main(String[] args) throws Exception {
        IpToInt ipToInt = new IpToInt();
        System.out.println(ipToInt.ipToInt("0.0.0.0"));
    }

    public Integer ipToInt(String ip) throws Exception {
        int dotnum = 0;
        int index = 0;
        int currentPart = 0;
        int result = 0;
        while (index < ip.length()) {
            char current = ip.charAt(index);
            if (current == '.') {
                result += convert(currentPart, 8 * (3 - dotnum));
                dotnum++;
                if (dotnum > 3) {
                    break;
                }
                currentPart = 0;
            } else {
                try {
                    if (currentPart == 0) {
                        currentPart += Integer.parseInt(current + "");
                    } else {
                        currentPart = currentPart * 10 + Integer.parseInt(current + "");
                    }
                } catch (Exception e) {
                    throw new Exception("not a IPV4");
                }
            }
            index++;
        }

        if ((index == ip.length() && dotnum < 3) || (index < ip.length() && dotnum > 3)) {
            throw new Exception("not a IPV4");
        }

        result += convert(currentPart, 0);

        return result;
    }

    private Integer convert(int currentPart, int base) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            int value = (int) Math.pow(2, 8 - i);
            if (value > currentPart) {
                temp.add(0);
            } else {
                temp.add(1);
                currentPart = currentPart - value;
            }
        }

        int i = 7;
        Integer result = 0;
        for (Integer e : temp) {
            result += e * (int) Math.pow(2, i + base);
            i--;
        }

        return result;
    }
}
