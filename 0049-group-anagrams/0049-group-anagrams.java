class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // build trie
        TrieNode trieRoot = new TrieNode();
        for (String s : strs) {
            addToTrie(trieRoot, s);
        }
        
        List<List<String>> result = new LinkedList<>();
        dfs(trieRoot, result);
        return result;
    }
    
    private void dfs(TrieNode root, List<List<String>> result) {
        if (!root.anagrams.isEmpty()) {
            result.add(root.anagrams);
        }
        
        for (TrieNode child : root.children.values()) {
            dfs(child, result);
        }
    }
    
    private void addToTrie(TrieNode root, String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        TrieNode current = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.anagrams.add(s);
    }
    
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<String> anagrams = new LinkedList();
    }
}