package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode208 {
    class Trie {
        private Set<String> wholeStr;
        private Set<String> prefixStr;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.wholeStr = new HashSet<>();
            this.prefixStr = new HashSet<>();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            this.wholeStr.add(word);

            for (int i = 1; i <= word.length(); i++) {
                this.prefixStr.add(word.substring(0, i));
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return this.wholeStr.contains(word);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return this.prefixStr.contains(prefix);
        }
    }
}
