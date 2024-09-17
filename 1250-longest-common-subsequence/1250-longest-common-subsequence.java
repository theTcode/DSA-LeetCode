class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        int ans = 0;
        int[][] dp = new int[i+1][j+1];
        // for(int r=0;r<i;r++){
        //    dp[r][0]=0;
        // }
        // for(int c=0;c<j;c++){
        //     dp[0][c] = 0;
        // }
        for(int r=1;r<=i;r++){
            for(int c=1;c<=j;c++){
                if(text1.charAt(r-1) == text2.charAt(c-1)){
                    ans = 1 + dp[r-1][c-1];
                }
                else{
                    ans = Math.max(dp[r][c-1], dp[r-1][c]);
                }
                dp[r][c] = ans;
            }
        }
        return dp[i][j];
    }
}