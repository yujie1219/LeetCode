package solution;

public class LeetCode468 {
    private class Result {
        public static final String IPv4 = "IPv4";
        public static final String IPv6 = "IPv6";
        public static final String Neither = "Neither";
    }

    public static void main(String[] args) {
        new LeetCode468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() < 7) {
            return Result.Neither;
        } else if (validIPv4(IP)) {
            return Result.IPv4;
        } else if (validIPv6(IP)) {
            return Result.IPv6;
        } else {
            return Result.Neither;
        }
    }

    private boolean validIPv6(String IP) {
        String[] splitIPs = IP.split(":");
        if (splitIPs.length != 8 || IP.endsWith(":")) {
            return false;
        }

        for (String splitIP : splitIPs) {
            if (splitIP.length() == 0 || splitIP.length() > 4) {
                return false;
            }

            for (char current : splitIP.toCharArray()) {
                if (!Character.isDigit(current) && !(Character.toLowerCase(current) >= 'a' && Character.toLowerCase(current) <= 'f')) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validIPv4(String IP) {
        if (IP.contains(":")) {
            return false;
        }

        int dotNum = 0;
        int tempNum = Integer.MIN_VALUE;
        for (int i = 0; i < IP.length(); i++) {
            char currentChar = IP.charAt(i);
            if (currentChar == '.') {
                if (tempNum < 0 || tempNum > 255) {
                    return false;
                }

                tempNum = Integer.MIN_VALUE;
                dotNum++;
            } else {
                if (Character.isDigit(currentChar)) {
                    if (tempNum == Integer.MIN_VALUE) {
                        tempNum = Integer.parseInt(currentChar + "");
                    } else {
                        if (tempNum == 0) {
                            return false;
                        } else {
                            tempNum = tempNum * 10 + Integer.parseInt(currentChar + "");
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        if (dotNum != 3) {
            return false;
        }

        if (tempNum < 0 || tempNum > 255) {
            return false;
        }

        return true;
    }
}
