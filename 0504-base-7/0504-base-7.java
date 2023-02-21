class Solution {
    private static final int BASE = 7;
    
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("-");
            num = Math.abs(num);
        }
        
        int maxPower = (int) Math.floor(Math.log(num) / Math.log(BASE));
        for (int i = maxPower; i >= 0; i--) {
            int place = (int) Math.pow(BASE, i);
            int digit = num / place;
            sb.append(digit);
            num %= place;
        }
        
        return sb.toString();
    }
}