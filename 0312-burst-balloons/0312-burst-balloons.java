class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coin = new int[n+2];

        coin[0] = 1;
        for(int i=0;i<n;i++){
            coin[i+1] = nums[i];
        }
        coin[n+1]=1;

        int[][] dp = new int[n+2][n+2];

        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j){
                    continue;
                }
                int maxi = Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = coin[i-1]*coin[ind]*coin[j+1] + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
    // public int sum(int i, int j, int[] nums, int[][] dp){
    //     if(i>j){
    //         return 0;
    //     }
    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     int maxi = Integer.MIN_VALUE;
    //     for(int ind=i;ind<=j;ind++){
    //         int cost = nums[i-1]*nums[ind]*nums[j+1] + sum(i, ind-1, nums, dp) + sum(ind+1, j, nums, dp);
    //         maxi = Math.max(maxi, cost);
    //     }
    //     return dp[i][j] = maxi;
    // }
}