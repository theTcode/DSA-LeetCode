class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coin = new int[n+2];

        coin[0] = 1;
        for(int i=0;i<n;i++){
            coin[i+1] = nums[i];
        }
        coin[n+1]=1;

        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return sum(1, n, coin, dp);
    }
    public int sum(int i, int j, int[] nums, int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = nums[i-1]*nums[ind]*nums[j+1] + sum(i, ind-1, nums, dp) + sum(ind+1, j, nums, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
}