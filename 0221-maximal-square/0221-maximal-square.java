class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[m+1];
        int prev = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1] == '1'){
                    int temp = dp[j];
                    dp[j] = Math.min(Math.min(dp[j], dp[j-1]), prev)+1;
                    prev = temp;
                    maxSide = Math.max(maxSide, dp[j]);

                }
                else{
                    prev = dp[j];
                    dp[j] = 0;
                }
            }
        }
        return maxSide*maxSide;
    }
}