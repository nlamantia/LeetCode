class Solution {
    private Map<Character, Character> sCharMap, tCharMap;
    
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) return true;
        
        sCharMap = new HashMap<>();
        tCharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (!isMapped(sCharMap, sc) && !isMapped(tCharMap, tc)) {
                sCharMap.put(sc, tc);
                tCharMap.put(tc, sc);
            } else if (!isConnected(sc, tc)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isMapped(Map<Character, Character> charMap, char c) {
        return charMap.containsKey(c);
    }
    
    private boolean isConnected(char sChar, char tChar) {
        return Character.valueOf(tChar).equals(sCharMap.get(sChar)) 
            && Character.valueOf(sChar).equals(tCharMap.get(tChar));
    }
}