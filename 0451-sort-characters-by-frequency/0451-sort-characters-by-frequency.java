class Solution {
    // O(n) time | O(n) space
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        StringBuffer[] buckets = new StringBuffer[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new StringBuffer();
            }
            
            for (int i = 0; i < freq; i++) {
                buckets[freq].append(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                sb.append(buckets[i]);
            }
        }
        return sb.toString();
    }
}