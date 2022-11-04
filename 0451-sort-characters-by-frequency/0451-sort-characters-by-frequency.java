class Solution {
    // O(n log n) time | O(n) space
    public String frequencySort(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        
        TreeMap<Integer, StringBuilder> buckets = new TreeMap<>(Comparator.reverseOrder());
        for (char c : charFreqMap.keySet()) {
            int freq = charFreqMap.get(c);
            StringBuilder buffer = buckets.getOrDefault(freq, new StringBuilder());
            for (int i = 0; i < freq; i++) {
                buffer.append(c);
            }
            buckets.put(freq, buffer);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!buckets.isEmpty()) {
            sb.append(buckets.pollFirstEntry().getValue());
        }
        return sb.toString();
    }
}