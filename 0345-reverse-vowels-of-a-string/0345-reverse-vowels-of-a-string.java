class Solution {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    
    // O(n) time | O(n) space
    public String reverseVowels(String s) {
        int firstVowel = 0, lastVowel = s.length() - 1;
        char[] chars = s.toCharArray();
        while (firstVowel < lastVowel) {
            while (firstVowel < s.length() && !VOWELS.contains(Character.toLowerCase(chars[firstVowel]))) {
                firstVowel++;
            }
            
            while (lastVowel >= 0 && !VOWELS.contains(Character.toLowerCase(chars[lastVowel]))) {
                lastVowel--;
            }
            
            if (firstVowel < lastVowel) {
                char temp = chars[firstVowel];
                chars[firstVowel] = chars[lastVowel];
                chars[lastVowel] = temp;
            }
            lastVowel--;
            firstVowel++;
        }
        return new String(chars);
    }
}