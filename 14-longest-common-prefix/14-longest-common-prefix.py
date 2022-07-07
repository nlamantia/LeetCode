class TrieNode:
    def __init__(self, value = None, endOfWord = False):
        self.value = value
        self.children = {}
        self.endOfWord = endOfWord


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        root = TrieNode()
        
        # build trie
        for s in strs:
            current = root
            for c in s:
                if c not in current.children:
                    current.children[c] = TrieNode(c)
                current = current.children[c]
            current.endOfWord = True
        
        # find longest prefix
        prefix = ''
        current = root
        while len(current.children.keys()) == 1 and not current.endOfWord:
            nextChar = next(iter(current.children))
            prefix += nextChar
            current = current.children[nextChar]
            
        return prefix