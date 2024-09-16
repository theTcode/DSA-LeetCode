class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i][j];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(i-1, j-1, text1, text2, 0, dp);
        // for(int k=0;k<j;k++){
        //     dp[i-1][k] = 0;
        // }
        // for(int r=1;r<i;r++){
        //     for(int c=0;c<j;c++){
        //         if(r<0 || c<0){
        //             return 0;
        //         }
        //         if(s1.charAt(r) == s2.charAt(c)){
        //             ans = 1 + dp[i-1][j-1];
        //         }
        //         else{
        //             ans = Math.max(lcs(i, j-1, s1, s2, ans), lcs(i-1, j, s1, s2, ans));
        //             }
        
        // }
        // dp[i][j] = ans;
    }
    private int lcs(int i, int j, String s1, String s2, int ans, int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + lcs(i-1, j-1, s1, s2, ans, dp);
        }
        else{
            ans = Math.max(lcs(i, j-1, s1, s2, ans, dp), lcs(i-1, j, s1, s2, ans, dp));
        }
        return dp[i][j] = ans;
    }
}