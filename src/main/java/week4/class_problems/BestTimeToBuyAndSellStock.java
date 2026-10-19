package week4.class_problems;
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int lowest = prices[0], best = 0;
        for (int i = 1; i < prices.length; i++) {
            best = Math.max(best, prices[i] - lowest);
            lowest = Math.min(lowest, prices[i]);
        }
        return best;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
