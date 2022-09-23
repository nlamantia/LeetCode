class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right - 1) {
            int middle = left + (right - left) / 2;
            if (isPeak(arr, middle)) {
                return middle;
            } else if (isStrictlyIncreasing(arr, middle)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return arr[left] > arr[right] ? left : right;
    }
    
    private boolean isPeak(int[] arr, int middle) {
        return (middle == 0 || arr[middle] > arr[middle - 1])
            && (middle == arr.length - 1 || arr[middle] > arr[middle + 1]);
    }
    
    private boolean isStrictlyIncreasing(int[] arr, int middle) {
        return (middle == 0 || arr[middle] > arr[middle - 1])
            && (middle == arr.length - 1 || arr[middle] < arr[middle + 1]);
    }
}