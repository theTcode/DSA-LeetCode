class Solution {
    public boolean isMatch(String s, String p) {
        int i = s.length();
        int j = p.length();
        boolean[][] dp = new boolean[i+1][j+1];
        dp[0][0] = true;
        for(int k=1;k<=j;k++){
            if(p.charAt(k-1)=='*'){
                dp[0][k] = dp[0][k-2];
            }
        }

        for(int n=1;n<=i;n++){
            for(int m=1;m<=j;m++){
                if(s.charAt(n-1) == p.charAt(m-1) || p.charAt(m-1) == '.'){
                    dp[n][m] = dp[n-1][m-1];
                }
                else if(p.charAt(m-1) == '*'){
                    dp[n][m] = (dp[n][m-2] || (match(s, p, n, m) && dp[n-1][m]));
                }
            }
        }
        return dp[i][j];
    }
    private boolean match(String s, String p, int i, int j){
        return (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.');
    }
}