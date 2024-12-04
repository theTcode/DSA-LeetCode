class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mini = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        
        for(int j=0;j<m;j++){
            dp[0][j] = grid[0][j];
        }
        
        for(int i=1;i<n;i++){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j=0;j<m;j++){
                if(dp[i-1][j]<min1){
                    min2 = min1;
                    min1 = dp[i-1][j];
                    minIndex = j;
                } else if(dp[i-1][j]<min2){
                    min2 = dp[i-1][j];
                }
            }

            for(int j=0;j<m;j++){
                if(minIndex == j){
                    dp[i][j] = grid[i][j] + min2;
                }
                else{
                    dp[i][j] = grid[i][j] + min1;
                }
            }
        }

        for(int j=0;j<m;j++){
            mini = Math.min(mini, dp[n-1][j]);
        }
        return mini;
    }
}