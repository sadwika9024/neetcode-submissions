class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {

        // We have processed the entire word
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // Normal character
        if (c != '.') {

            int childIndex = c - 'a';

            if (node.children[childIndex] == null) {
                return false;
            }

            return dfs(node.children[childIndex], word, index + 1);
        }

        // '.' can represent any character
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                if (dfs(node.children[i], word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}