class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        
        result.add("");
        Map<Integer, Set<Character>> digitChars = buildDigitCharMap();
        for (char digit : digits.toCharArray()) {
            List<String> newResult = new ArrayList<>();
            for (char c : digitChars.get(Integer.parseInt("" + digit))) {
                List<String> prefixes = new ArrayList<>(result);
                for (String prefix : prefixes) {
                    newResult.add(prefix + c);
                }
            }
            result = newResult;
        }
        return result;
    }
    
    private Map<Integer, Set<Character>> buildDigitCharMap() {
        Map<Integer, Set<Character>> result = new HashMap<>();
        int currentDigit = 2, digitCount = 0;
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            char c = (char) i;
            if (!result.containsKey(currentDigit)) {
                result.put(currentDigit, new HashSet<>());
            }
            result.get(currentDigit).add(c);
            
            digitCount++;
            if (shouldAdvanceDigit(currentDigit, digitCount)) {
                currentDigit++;
                digitCount = 0;
            }
        }
        return result;
    }
    
    private boolean shouldAdvanceDigit(int currentDigit, int digitCount) {
        int maxCount = (currentDigit == 7 || currentDigit == 9) ? 4 : 3;
        return digitCount == maxCount;
    }
}