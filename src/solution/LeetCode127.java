package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode127 {

    public static void main(String[] args) {
        new LeetCode127().ladderLength("ymain", "oecij", Stream.of("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain").collect(Collectors.toList()));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int road = 1;

        if (canChangeToWord(beginWord, endWord)) {
            return ++road;
        }

        int[] pass = new int[wordList.size()];
        pass[wordList.indexOf(endWord)] = 1;

        List<String> last = new ArrayList<>();
        last.add(endWord);

        while (road >= 0) {
            road++;

            List<String> pathWord = new ArrayList<>();
            for (String currentWord : last) {

                for (int i = 0; i < wordList.size(); i++) {
                    if (pass[i] == 0) {
                        String word = wordList.get(i);
                        if (canChangeToWord(currentWord, word)) {
                            if (canChangeToWord(beginWord, word)) {
                                return road + 1;
                            }

                            pathWord.add(word);
                            pass[i] = 1;
                        }
                    }
                }
            }

            if (pathWord.size() == 0) {
                return 0;
            }
            last = pathWord;
        }

        return road;
    }

    private boolean canChangeToWord(String targetWord, String word) {
        int sameWord = 0;
        int beginWordLength = targetWord.length();
        for (int i = 0; i < beginWordLength; i++) {
            if (targetWord.charAt(i) == word.charAt(i)) {
                sameWord++;
            }
        }

        if (sameWord == beginWordLength - 1) {
            return true;
        }

        return false;
    }


}
