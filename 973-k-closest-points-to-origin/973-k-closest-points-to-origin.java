class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] closestPoints = new int[k][];
        PriorityQueue<HeapNode> heap = new PriorityQueue<>(Comparator.comparing((HeapNode node) -> node.distance).reversed());
        
        for (int[] point : points) {
            if (heap.size() < k || isOneOfKClosest(heap, point)) {
                heap.add(new HeapNode(point, euclideanDistanceFromOrigin(point)));
            }
        }
        
        for (int i = 0; i < k; i++) {
            closestPoints[i] = heap.poll().point;
        }
        
        return closestPoints;
    }
    
    private boolean isOneOfKClosest(PriorityQueue<HeapNode> heap, int[] point) {
        double distFromOrigin = euclideanDistanceFromOrigin(point);
        if (distFromOrigin < heap.peek().distance) {
            heap.poll();
            return true;
        }
        return false;
    }
    
    private double euclideanDistanceFromOrigin(int[] p) {
        return Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
    }
    
    private class HeapNode {
        int[] point;
        double distance;
        
        HeapNode(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}