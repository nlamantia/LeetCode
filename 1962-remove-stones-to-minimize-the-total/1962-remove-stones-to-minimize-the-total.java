class Solution {
    // O((n + k) * log n) time | O(n) space
    public int minStoneSum(int[] piles, int k) {
        // add all piles to max heap - O(n log n)
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int p : piles) {
            heap.offer(p);
        }

        // perform halving operation k times - O(k log n)
        for (int i = 0; i < k; i++) {
            int maxPile = heap.poll();
            heap.offer(maxPile - (maxPile / 2));
        }

        // sum up the heap items - O(n log n)
        int sum = 0;
        while (!heap.isEmpty()) {
            sum += heap.poll();
        }

        return sum;
    }
}