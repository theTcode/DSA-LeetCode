class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int cost = 0;

        for(int i=n-1;i>=0;i--){
            int mini = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrome(i, j, s)){
                    cost = 1 + dp[j+1];
                }
                mini = Math.min(cost, mini);
            }
            dp[i] = mini;
        }
        return dp[0] - 1;
    }
    // public int f(int i, String s,  int[] dp){
    //     if(i==s.length()){
    //         return 0;
    //     }
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }
    //     int cost = 0;
        
    //     for(int j=i;j<s.length();j++){
    //         if(isPalindrome(i, j, s)){
    //             cost = 1 + f(j+1, s, dp);
    //         }
    //         min = Math.min(cost, min);
    //     }
    //     return dp[i] = min;
    // }
    public boolean isPalindrome(int i, int j, String c){
        while(i<=j){
            if(c.charAt(i) != c.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}