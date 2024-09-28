class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int b=0;b<=1;b++){
                for(int t=1;t<=2;t++){
                    if(b==1){
                        dp[ind][b][t] =  Math.max(-prices[ind] + dp[ind+1][0][t], dp[ind+1][1][t]);
                    }
                    else{
                        dp[ind][b][t] = Math.max(prices[ind] + dp[ind+1][1][t-1], dp[ind+1][0][t]);
                    }
                }
            }
        }  
        return dp[0][1][2];
    }  
}