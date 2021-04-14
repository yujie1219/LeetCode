package solution;

public class LeetCode208Re {
    class Trie {

        private TrieTree root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieTree();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            root.insert(word);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return root.search(word, true);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return root.search(prefix, false);
        }
    }

    private class TrieTree {
        private TrieTree[] children;
        private boolean[] isEnd;

        public TrieTree() {
            children = new TrieTree[26];
            isEnd = new boolean[26];
        }

        private void insert(String word) {
            Character currentCh = word.charAt(0);
            TrieTree child = null;
            if (children[currentCh - 'a'] != null) {
                child = children[currentCh - 'a'];
            } else {
                child = new TrieTree();
                children[currentCh - 'a'] = child;
            }

            if (word.length() > 1) {
                child.insert(word.substring(1));
            } else {
                isEnd[currentCh - 'a'] = true;
            }
        }

        private boolean search(String word, boolean findEnd) {
            Character currentCh = word.charAt(0);

            if (word.length() == 1) {
                if (children[currentCh - 'a'] != null) {
                    return findEnd ? isEnd[currentCh - 'a'] : true;
                } else {
                    return false;
                }
            } else {
                if (children[currentCh - 'a'] != null) {
                    return children[currentCh - 'a'].search(word.substring(1), findEnd);
                } else {
                    return false;
                }
            }
        }
    }
}
