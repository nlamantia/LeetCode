class Solution {
    // O(n + (k log k)) time | O(n + k) space
    public int[] topKFrequent(int[] nums, int k) {
        if (k >= nums.length) return nums;
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            Comparator.comparing(Map.Entry<Integer, Integer>::getValue)
        );
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (heap.size() < k) {
                heap.offer(entry);
            } else if (heap.peek().getValue() < entry.getValue()) {
                heap.poll();
                heap.offer(entry);
            }
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}