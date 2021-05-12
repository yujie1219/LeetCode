package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode388 {
    public static void main(String[] args) {
        new LeetCode388().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }

    public int lengthLongestPath(String input) {
        String[] inputs = input.split("\n");

        int max = 0;
        int index = 0;
        List<String> tempResult = new ArrayList<>();
        while (index < inputs.length) {
            String currentPath = inputs[index];
            int tNum = getTNum(currentPath);
            currentPath = currentPath.substring(tNum);

            while (tempResult.size() > tNum) {
                tempResult.remove(tempResult.size() - 1);
            }

            tempResult.add(currentPath);

            if (isFile(currentPath)) {
                max = Math.max(max, getLength(tempResult));
            }
            index++;
        }

        return max;
    }

    private int getLength(List<String> paths) {
        int result = 0;
        for (String path : paths) {
            result += path.length() + 1;
        }

        return result == 0 ? result : result - 1;
    }

    private boolean isFile(String word) {
        return word.contains(".");
    }

    private int getTNum(String word) {
        Pattern pattern = Pattern.compile("((\\t)*).*");
        Matcher matcher = pattern.matcher(word);

        if (matcher.find()) {
            String test = matcher.group(1);
            return matcher.group(1).length();
        }

        return 0;
    }
}
