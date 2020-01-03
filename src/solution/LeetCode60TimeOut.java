package solution;

public class LeetCode60TimeOut {

    // timeout
    public static void main(String[] args) {
        LeetCode60TimeOut leetCode60 = new LeetCode60TimeOut();
        System.out.println(leetCode60.getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            s += i;
        }

        String result = s;
        for (int i = 1; i < k; i++) {
            result = LexicographicOrder(result);
        }

        return result;
    }

    private String LexicographicOrder(String s) {
        String[] sArr = s.split("");
        int j = 0;
        for (int i = sArr.length - 2; i >= 0; i--) {
            if (Integer.parseInt(sArr[i]) < Integer.parseInt(sArr[i + 1])) {
                j = i;
                break;
            }
        }

        int min = j + 1;
        for (int i = j + 1; i < sArr.length; i++) {
            if (Integer.parseInt(sArr[i]) > Integer.parseInt(sArr[j]) && Integer.parseInt(sArr[min]) > Integer.parseInt(sArr[i])) {
                min = i;
            }
        }

        String temp = sArr[j];
        sArr[j] = sArr[min];
        sArr[min] = temp;

        String result = "";
        for (int i = 0; i <= j; i++) {
            result += sArr[i];
        }

        for (int i = sArr.length - 1; i > j; i--) {
            result += sArr[i];
        }

        return result;
    }
}
