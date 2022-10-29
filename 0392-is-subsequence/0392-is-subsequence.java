class Solution {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        for (int tp = 0; sp < s.length() && tp < t.length(); tp++) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
        }
        return sp == s.length();
    }
}