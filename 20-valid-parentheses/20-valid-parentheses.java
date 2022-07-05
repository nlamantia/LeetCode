class Solution {
    public boolean isValid(String s) {
        Deque<Character> bracketStack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpeningBracket(c)) {
                bracketStack.push(c);
            } else if (bracketStack.peek() != null && bracketStack.peek() == openingBracket(c)) {
                bracketStack.pop();
            } else {
                return false;
            }
        }
        
        return bracketStack.isEmpty();
    }
    
    private boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    private char openingBracket(char c) {
        return (char) (c == ')' ? c - 1 : c - 2);
    }
}