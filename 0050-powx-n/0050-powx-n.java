class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        
        double product = n == 0 ? 1 : Math.abs(x);
        if (product != 1 && (Math.abs(n) - 1) > 0) {
            int power = 1;
            while (product > 0 && product < Double.MAX_VALUE && power * 2 <= Math.abs(n) - 1) {
                product = multiply(product, product);
                power *= 2;
            }

            if (product > 0) {
                for (int i = power; i <= Math.abs(n) - 1 && product < Double.MAX_VALUE; i++) {
                    product = multiply(product, Math.abs(x));
                }
            }
        }
        
        
        if (n < 0) {
            product = 1 / product;
        }
        
        return (x < 0 && n % 2 == 1) ? (-1 * product) : product;
    }
    
    private double multiply(double num1, double num2) {
        if ((Double.MAX_VALUE / num1) < num2 || (Double.MAX_VALUE / num2) < num1) {
            return Double.MAX_VALUE;
        }
        return num1 * num2;
    }
}