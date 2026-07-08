class Solution {
    public int maxProfit(int[] prices) {
        int minPric = prices[0];
        int profit = 0;
        for(int i=0;i<prices.length;i++)
        {
            minPric = Math.min(prices[i],minPric);

            profit = Math.max(profit , prices[i]-minPric);

        }
        return profit;
    }
}
