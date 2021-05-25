package Algorithms;

public class ToBinaryString {
    public static void main(String[] args) {
        if (ToBinaryString.toBinaryString(10).equals(Integer.toBinaryString(10))) {
            System.out.println("same");
        } else {
            System.out.println("wrong");
        }
    }

    public static String toBinaryString(int i) {
        StringBuilder stringBuilder = new StringBuilder();

        while (i != 0) {
            stringBuilder.append(i % 2);
            i = i / 2;
        }

        return stringBuilder.reverse().toString();
    }
}
