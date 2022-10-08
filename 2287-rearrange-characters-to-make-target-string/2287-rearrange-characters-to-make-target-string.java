class Solution {
    public int rearrangeCharacters(String s, String target) {
        // initialize hash maps for target ratios and actual character counts
        Map<Character, Integer> targetRatios = new HashMap<>();
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            targetRatios.put(c, targetRatios.getOrDefault(c, 0) + 1);
            charCounts.put(c, 0);
        }
        
        // count the relevant characters from s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) + 1);
            }
        }
        
        // find minimum number of times the letters in that word can be formed given the counts
        int copies = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            copies = Math.min(copies, entry.getValue() / targetRatios.get(entry.getKey()));
        }
        return copies;
    }
}