class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return stockCool(0, prices, 1, dp);
    }
    private int stockCool(int ind, int[] prices, int buy, int[][] dp){
        if(ind>=prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        if(buy==1){
            return dp[ind][buy] = Math.max(-prices[ind] + stockCool(ind+1, prices, 0, dp), stockCool(ind+1, prices, 1, dp));
        }
        return dp[ind][buy] = Math.max(prices[ind] + stockCool(ind+2, prices, 1, dp), stockCool(ind+1, prices, 0, dp));
    }
}