package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    public static void main(String[] args) {
        new LeetCode93().restoreIpAddresses("10101010");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() > 0) {
            seperateIp(s.split(""), results, "", 0, "");
        }

        return results;
    }

    private void seperateIp(String[] ip, List<String> results, String result, int index, String currentInteger) {
        if (index >= ip.length) {
            return;
        }

        if (result.equals("10.101.")) {
            System.out.println("");
        }

        if (result.split("\\.").length == 2 && (ip.length - 1 - index + currentInteger.length() >= 6)) {
            return;
        }

        if (result.split("\\.").length == 3) {
            if (ip.length - 1 - index + currentInteger.length() >= 3) {
                return;
            }

            for (int i = index; i < ip.length; i++) {
                currentInteger += ip[i];
            }

            if (currentInteger.startsWith("0") && (Integer.parseInt(currentInteger) > 0 || currentInteger.length() > 1)) {
                return;
            }

            if (Integer.parseInt(currentInteger) <= 255 && !results.contains(result + currentInteger)) {
                results.add(result + currentInteger);
            }
            return;
        }

        if (currentInteger != "") {
            if (Integer.parseInt(currentInteger + ip[index]) <= 255) {
                seperateIp(ip, results, result + currentInteger + ip[index] + ".", index + 1, "");
                seperateIp(ip, results, result, index + 1, currentInteger + ip[index]);
            } else {
                if (Integer.parseInt(ip[index]) == 0) {
                    seperateIp(ip, results, result + currentInteger + ".0.", index + 1, "");
                } else {
                    seperateIp(ip, results, result + currentInteger + ".", index + 1, ip[index]);
                }
            }
        } else {
            if (Integer.parseInt(ip[index]) != 0) {
                seperateIp(ip, results, result, index + 1, ip[index]);
            }
            seperateIp(ip, results, result + ip[index] + ".", index + 1, "");
        }

    }
}
