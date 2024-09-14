class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        int ans = f(coins, n-1, amount, dp);
        if(ans>1e7){
            return -1;
        }
        return ans;
    }
    private int f(int[] a, int n, int target, int[][] dp){
        if(n==0){
            if(target % a[0]==0){
                return target/a[0];
            }
            return (int)1e8;
        }
        if(dp[n][target] != 0){
            return dp[n][target];
        }
        int notTake = 0 + f(a, n-1, target, dp);
        int take = (int)1e8;
        if(a[n] <= target){
            take = 1 + f(a, n, target-a[n], dp);
        }
        return dp[n][target] = Math.min(take, notTake);
    }
}