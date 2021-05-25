package solution;

public class LeetCode424 {
    public static void main(String[] args) {
        new LeetCode424().characterReplacement("AABABBA", 1);
    }

    public int characterReplacement(String s, int k) {
        int length = s.length();
        int max = 0;

        if (length == 0 || length == 1) {
            return length;
        }

        int index = 0;
        int currentLength = 1;
        int[] occurrenceFrequency = new int[26];
        while (length - index > max) {
            occurrenceFrequency[s.charAt(index) - 'A']++;
            int maxShow = 1;

            while (index + currentLength < length && currentLength - maxShow <= k) {
                occurrenceFrequency[s.charAt(index + currentLength) - 'A']++;
                maxShow = Math.max(maxShow, occurrenceFrequency[s.charAt(index + currentLength) - 'A']);
                currentLength++;
            }

            max = Math.max(max, currentLength - maxShow <= k ? currentLength : currentLength - 1);
            index++;
            occurrenceFrequency = new int[26];
            currentLength = 1;
        }

        return max;
    }
}
