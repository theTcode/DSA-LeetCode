class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] a1 : dp){
            for(int[] a2 : a1){
                Arrays.fill(a2, -1);
            }
        }
        return helper(0, 1, 2, prices, dp);
    }
    private int helper(int ind, int buy, int trxn, int[] prices, int[][][] dp){
        if(ind==prices.length || trxn == 0){
            return 0;
        }
        if(dp[ind][buy][trxn] != -1){
            return dp[ind][buy][trxn];
        }
        if(buy==1){
            return dp[ind][1][trxn] =  Math.max(-prices[ind] + helper(ind+1, 0, trxn, prices, dp), helper(ind+1, 1, trxn, prices, dp));
        }
        else{
            return dp[ind][0][trxn] = Math.max(prices[ind] + helper(ind+1, 1, trxn-1, prices, dp), helper(ind+1, 0, trxn, prices, dp));
        }  
    }
}