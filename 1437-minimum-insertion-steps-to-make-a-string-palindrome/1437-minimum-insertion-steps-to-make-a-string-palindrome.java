class Solution {
    public int minInsertions(String s) {
        return s.length() - longestPS(s);
    }
    public int longestPS(String s){
        StringBuilder st = new StringBuilder(s);
        String t = st.reverse().toString();
        return longestCommonSubsequence(s, t);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i+1][j+1];
        for(int r=1;r<=i;r++){
            for(int c=1;c<=j;c++){
                if(text1.charAt(r-1) == text2.charAt(c-1)){
                    dp[r][c] = 1 + dp[r-1][c-1];
                }
                else{
                    dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]);
                }
            }
        }
        return dp[i][j];
    }
}