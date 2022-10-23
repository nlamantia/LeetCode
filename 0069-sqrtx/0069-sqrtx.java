class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        
        int start = 0, end = x;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if ((x / middle) == middle) {
                return middle;
            } else if ((x / middle) < middle) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return start;
    }
}