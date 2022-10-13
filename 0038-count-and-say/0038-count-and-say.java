class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String nMinus1 = countAndSay(n - 1);
            char currentDigit = nMinus1.charAt(0);
            int count = 1;
            StringBuilder result = new StringBuilder();
            for (int i = 1; i < nMinus1.length(); i++) {
                if (nMinus1.charAt(i) == currentDigit) {
                    count++;
                } else {
                    result.append(count).append(currentDigit);
                    count = 1;
                    currentDigit = nMinus1.charAt(i);
                }
            }
            result.append(count).append(currentDigit);
            return result.toString();
        }
    }
}