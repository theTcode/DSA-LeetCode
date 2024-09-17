class Solution {
    //Approach-1
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        int ans = 0;
        int[][] dp = new int[i+1][j+1];
        // We can remove these two loops because, in Java, the default value of elements in an array is 0.
        // So we can directly start from row=1 & col=1.
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

    //Approach-2
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i][j];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(i-1, j-1, text1, text2, 0, dp);
        
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
