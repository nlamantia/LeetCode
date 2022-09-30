class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        
        int num1 = 1, num2 = 0;
        for (int i = 2; i <= n; i++) {
            int temp = num2;
            num2 = num1;
            num1 = temp + num2;
        }
        return num1;
    }
}