class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() == 2 && minHeap.peek() > nums[i] - 1) continue;
            
            if (minHeap.size() == 2) {
                minHeap.poll();
            }
            
            minHeap.add(nums[i] - 1);
        }
        
        System.out.println(minHeap.toString());
        
        return product(minHeap);
    }
    
    private int product(PriorityQueue<Integer> minHeap) {
        int product = 1;
        while (!minHeap.isEmpty()) {
            product *= minHeap.poll();
        }
        return product;
    }
}