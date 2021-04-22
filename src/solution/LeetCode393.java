package solution;

public class LeetCode393 {
    public static void main(String[] args) {
        new LeetCode393().validUtf8(new int[]{235, 140, 4});
    }

    public boolean validUtf8(int[] data) {
        int length = data.length;
        String[] dataBinary = new String[length];

        for (int i = 0; i < length; i++) {
            dataBinary[i] = toBinary(data[i]);
        }

        int need10 = 0;
        for (int i = 0; i < length; i++) {
            String current = dataBinary[i];

            if (current.startsWith("0")) {
                if (need10 != 0) {
                    return false;
                }
            } else if (current.startsWith("10")) {
                need10--;
                if (need10 < 0) {
                    return false;
                }
            } else if (current.startsWith("110")) {
                if (need10 != 0) {
                    return false;
                }
                need10 = 1;
            } else if (current.startsWith("1110")) {
                if (need10 != 0) {
                    return false;
                }
                need10 = 2;
            } else if (current.startsWith("11110")) {
                if (need10 != 0) {
                    return false;
                }
                need10 = 3;
            } else {
                return false;
            }
        }

        return need10 == 0;
    }

    private String toBinary(int data) {
        StringBuilder stringBuilder = new StringBuilder();

        while (data != 0) {
            stringBuilder.append(data % 2);
            data = data / 2;
        }

        while (stringBuilder.length() < 8) {
            stringBuilder.append(0);
        }

        return stringBuilder.reverse().toString();
    }
}
