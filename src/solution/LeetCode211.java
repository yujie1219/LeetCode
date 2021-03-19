package solution;

import model.TireNode;

public class LeetCode211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.search("a");
        wordDictionary.search(".at");
        wordDictionary.addWord("bat");
        wordDictionary.search(".at");
        wordDictionary.search("an.");
        wordDictionary.search("a.d.");
        wordDictionary.search("b.");
        wordDictionary.search("a.d");
        wordDictionary.search(".");

    }

    static class WordDictionary {

        private TireNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            this.root = new TireNode();
        }

        public void addWord(String word) {
            TireNode current = root;

            for (int i = 0; i < word.length(); i++) {
                Character currentCh = word.charAt(i);
                if (current.getChild(currentCh) == null) {
                    current.addChild(currentCh);
                }
                current = current.getChild(currentCh);
            }

            current.setEnd();
        }

        public boolean search(String word) {
            return findCh(root, word, 0);
        }

        private boolean findCh(TireNode currentNode, String word, int currentIndex) {
            if (currentIndex == word.length()) {
                return currentNode.isEnd();
            }

            Character currentCh = word.charAt(currentIndex);
            if (currentCh != '.') {
                if (currentNode.getChild(currentCh) != null) {
                    return findCh(currentNode.getChild(currentCh), word, currentIndex + 1);
                } else {
                    return false;
                }
            } else {
                for (TireNode node : currentNode.getChildren()) {
                    if (node != null && findCh(node, word, currentIndex + 1)) {
                        return true;
                    }
                }

                return false;
            }
        }
    }
}
