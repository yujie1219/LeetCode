package solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {

    // dp[i] 表示i长度的字符串是否符合要求
    // 当dp[j] 和 s.sub(j,i)都符合要求的时候， dp[i] 就符合要求
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
