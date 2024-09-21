class Solution {
    public boolean isMatch(String s, String p) {
        int i = s.length();
        int j = p.length();
        int[][] dp = new int[i][j];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = find(i-1, j-1, s, p, dp);
        return (ans==1)?true:false;
    }
    private int find(int i, int j, String s, String p, int[][] dp){
        if(i<0 && j<0){
            return 1;
        }
        if(i>=0 && j<0){
            return 0;
        }
        if(i<0 && j>=0){
            for(int n=0;n<=j;n++){
                if(p.charAt(n) != '*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = find(i-1, j-1, s, p, dp);
        }
        if(p.charAt(j)=='*'){
            return dp[i][j] = find(i, j-1, s, p, dp) | find(i-1, j, s, p, dp);
        }
        return 0;
    }
}