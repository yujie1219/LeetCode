package solution;

public class LeetCode151 {

    public static void main(String[] args) {
        new LeetCode151().reverseWords("a        b");
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        s = s.trim();
        String[] words = s.split(" ");
        String reversed = "";
        if (words.length > 0) {
            int i = words.length - 1;
            while (i >= 0) {
                if (!"".equals(words[i])) {
                    reversed = words[i];
                    i--;
                    break;
                }
                i--;
            }

            while (i >= 0) {
                if (!"".equals(words[i])) {
                    reversed += " " + words[i];
                }
                i--;
            }
        }

        return reversed;
    }
}
