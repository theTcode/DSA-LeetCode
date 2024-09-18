class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = f(coins, n-1, amount, dp);
        return ans;
    }
    private int f(int[] a, int n, int target, int[][] dp){
        if(n==0 || target==0){
            if(target % a[0]==0){
                return 1;
            }
            return 0;
        }
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        int notTake =f(a, n-1, target, dp);
        int take = 0;
        if(a[n] <= target){
            take = f(a, n, target-a[n], dp);
        }
        return dp[n][target] = (take + notTake);
    }
}