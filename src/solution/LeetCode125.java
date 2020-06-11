package solution;

public class LeetCode125 {
    public static void main(String[] args) {
        new LeetCode125().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {

        String parse = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = parse.length() - 1;

        while (start <= end) {
            if (parse.charAt(start) != parse.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
