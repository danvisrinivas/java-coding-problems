package leetcode;

public class BuyAndSellAtProfit {
//    buy and sell at future date
    public static void main(String[] args) {
        int[] prices = {6, 8, 9, 3, 5, 10, 17, 1};
        int maxProfit = findMaxProfitBuyAndSellInFuture(prices);
        System.out.println("Maximum profit: " + maxProfit);
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int maxProfitOnEachDay = maxProfitBuyAndSellEachDay(prices1);
        System.out.println("Maximum profit: " + maxProfitOnEachDay);
    }

    public static int findMaxProfitBuyAndSellInFuture(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;  // No profit possible
        }

        int minPrice = prices[0];  // Initialize min price to the first element
        int maxProfit = 0;  // Initialize max profit

        // Loop through the array to find the maximum profit
        for (int i = 1; i < prices.length; i++) {
            // Update minPrice if a lower price is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit and update maxProfit if the current profit is greater
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static int maxProfitBuyAndSellEachDay(int[] prices){
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update minPrice if a lower price is found
            if (prices[i-1] < prices[i]) {
                int currentProfit = prices[i] - prices[i-1];
                maxProfit = maxProfit+currentProfit;
            }
        }
        return maxProfit;
    }
}

