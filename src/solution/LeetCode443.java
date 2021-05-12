package solution;

public class LeetCode443 {
    public static void main(String[] args) {
        new LeetCode443().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
    }

    public int compress(char[] chars) {
        int left = 0;
        int right = 0;

        char current = chars[left];
        while (right < chars.length) {
            int gap = 0;
            while (right < chars.length && chars[right] == current) {
                right++;
                gap++;
            }

            chars[left] = current;
            if (gap > 1) {
                while ((gap + "").length() != 1) {
                    double base = Math.pow(10, (gap + "").length() - 1);
                    chars[++left] = (char) (gap / base + '0');
                    gap = (int) (gap % base);
                }

                chars[++left] = (char) (gap + '0');
            }

            if (right < chars.length) {
                current = chars[right];
                left++;
            }
        }

        return left + 1;
    }
}
