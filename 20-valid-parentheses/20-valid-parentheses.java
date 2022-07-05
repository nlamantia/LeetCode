class Solution {
    public boolean isValid(String s) {
        Deque<Character> bracketStack = new ArrayDeque<>();
        Map<Character, Character> closingBrackets = new HashMap<>();
        closingBrackets.put('(', ')');
        closingBrackets.put('[', ']');
        closingBrackets.put('{', '}');
        
        Map<Character, Character> openingBrackets = new HashMap<>();
        openingBrackets.put(')', '(');
        openingBrackets.put(']', '[');
        openingBrackets.put('}', '{');
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (closingBrackets.containsKey(c)) {
                bracketStack.push(c);
            } else if (bracketStack.peek() == openingBrackets.get(c)) {
                bracketStack.pop();
            } else {
                return false;
            }
        }
        
        return bracketStack.isEmpty();
    }
}