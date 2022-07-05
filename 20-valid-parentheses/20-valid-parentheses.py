class Solution:
    def isValid(self, s: str) -> bool:
        bracketStack = deque([])
        closingBrackets = {
            ')': '(',
            ']': '[',
            '}': '{'
        }
        
        for c in s:
            if c in closingBrackets and bracketStack and closingBrackets[c] == bracketStack[0]:
                bracketStack.popleft()
            else:
                bracketStack.appendleft(c)
                
        return len(bracketStack) == 0
        