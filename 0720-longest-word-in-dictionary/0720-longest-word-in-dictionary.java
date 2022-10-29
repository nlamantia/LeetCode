class Solution {
    // O(m * n) time | O(m * n) space
    public String longestWord(String[] words) {
        TrieNode trieRoot = new TrieNode();
        trieRoot.word = ""; // empty string counts as word for DFS purposes
        
        for (String word : words) {
            addToTrie(trieRoot, word);
        }
        
        return dfs(trieRoot);
    }
    
    private String dfs(TrieNode node) {
        if (node.word == null) return "";
        
        String currentLongestWord = node.word;
        for (TrieNode child : node.children.values()) {
            currentLongestWord = longerWord(currentLongestWord, dfs(child));
        }
        
        return currentLongestWord;
    }
    
    private String longerWord(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return s1;
        } else if (s1.length() < s2.length()) {
            return s2;
        } else {
            return s1.compareTo(s2) > 0 ? s2 : s1;
        }
    }
    
    private void addToTrie(TrieNode root, String s) {
        TrieNode current = root;
        for (char c : s.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.word = s;
    }
    
    private class TrieNode {
        String word;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}