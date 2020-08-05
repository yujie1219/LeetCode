package solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode165 {
    public static void main(String[] args) {
        new LeetCode165().compareVersion("1.1", "1.10");
    }

    public int compareVersion(String version1, String version2) {
        version1 = formatVersion(version1);
        version2 = formatVersion(version2);

        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < num1.length && j < num2.length) {
            if (Integer.parseInt(num1[i]) > Integer.parseInt(num2[j])) {
                return 1;
            } else if (Integer.parseInt(num1[i]) < Integer.parseInt(num2[j])) {
                return -1;
            }

            i++;
            j++;
        }

        if (i == num1.length && j == num2.length) {
            return 0;
        } else {
            if (i == num1.length) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private String formatVersion(String version) {
        String[] split = version.split("\\.");
        String result = "";
        boolean last = true;

        for (int i = split.length - 1; i >= 0; i--) {
            Pattern pattern = Pattern.compile("0+(\\d*)");
            Matcher matcher = pattern.matcher(split[i]);
            if (matcher.matches()) {
                String match = matcher.group(1);
                if (match.equals("0") || match.equals("")) {
                    if (!last) {
                        result = "0." + result;
                        last = false;
                    }
                } else {
                    result = match + "." + result;
                    last = false;
                }
            } else {
                result = split[i] + "." + result;
                last = false;
            }
        }

        if (result.length() > 1)
            result = result.substring(0, result.length() - 1);
        return result.equals("") ? "0" : result;
    }
}
