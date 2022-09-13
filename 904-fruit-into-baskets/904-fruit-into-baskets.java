class Solution {
    private static final int NUM_OF_BASKETS = 2;
    
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitTypes = new HashMap<>();
        int start = 0, end = 0, maxFruits = -1;
        while (end < fruits.length) {
            if (!fruitTypes.containsKey(fruits[end])) {
                fruitTypes.put(fruits[end], 0);
            }
            fruitTypes.put(fruits[end], fruitTypes.get(fruits[end]) + 1);
            while (fruitTypes.size() > NUM_OF_BASKETS) {
                int fruitType = fruits[start++];
                int typeCount = fruitTypes.get(fruitType) - 1;
                if (typeCount == 0) {
                    fruitTypes.remove(fruitType);
                } else {
                    fruitTypes.put(fruitType, typeCount);
                }
            }
            maxFruits = Math.max(maxFruits, end - start + 1);
            end++;
        }
        return maxFruits;
    }
}