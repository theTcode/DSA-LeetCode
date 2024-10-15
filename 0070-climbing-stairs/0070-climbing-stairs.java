class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, n, dp);
    }
    public int f(int currS, int last, int[] dp){
        if(currS > last){
            return 0;
        }
        if(currS == last){
            return 1;
        }
        if(dp[currS] != -1){
            return dp[currS];
        }
        return dp[currS] = f(currS + 1, last, dp) + f(currS + 2, last, dp);
    }
}