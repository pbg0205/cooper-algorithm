package solved_problem.leetcode.design_add_and_search_words_data_structure;

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    private static class TrieNode {
        private boolean isWord;
        private TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public TrieNode getChildNodeByIndex(int index) {
            if (index < 0 || index >= 26) {
                return null;
            }
            return this.children[index];
        }

        public void setNewChildNodeByIndex(int index) {
            this.children[index] = new TrieNode();
        }

    }


    public void addWord(String word) {
        TrieNode node = root;

        for (int wordIdx = 0; wordIdx < word.length(); wordIdx++) {
            int currentWordIdx = word.charAt(wordIdx) - 'a';
            if (node.getChildNodeByIndex(currentWordIdx) == null) {
                node.setNewChildNodeByIndex(currentWordIdx);
            }
            node = node.getChildNodeByIndex(currentWordIdx);
        }
        node.isWord = true;
    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean searching(String word, TrieNode node, int wordIdx) {
        if (node == null) {
            return false;
        }

        for (int charIdx = wordIdx; charIdx < word.length(); charIdx++) {
            char wordChar = word.charAt(charIdx);
            int alphabetIdx = wordChar - 'a';

            if (isWildCard(wordChar)) {
                for (int childCharIdx = 0; childCharIdx < node.children.length; childCharIdx++) {
                    if (searching(word, node.children[childCharIdx], charIdx + 1)) {
                        return true;
                    }
                }
                return false;
            }
            if (node.children[alphabetIdx] == null) return false;
            node = node.children[alphabetIdx];
        }
        return node.isWord;
    }

    private static boolean isWildCard(char wordChar) {
        char wildcard = '.';
        return wordChar == wildcard;
    }

    public boolean search(String word) {
        return searching(word, root, 0);
    }

}
