class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        Arrays.sort(cuts);
        int[] newCut = new int[cuts.length + 2];
        newCut[0] = 0;
        for(int i=0;i<cuts.length;i++){
            newCut[i+1] = cuts[i];
        }
        newCut[newCut.length-1] = n;
        int[][] dp = new int[c+1][c+1]; 
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return cost(newCut, n, 1, c, dp);
    }
    public int cost(int[] arr, int n, int i, int j, int[][] dp){
        int mini = Integer.MAX_VALUE;
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int ind=i;ind<=j;ind++){
            int cost = (arr[j+1]-arr[i-1]) + cost(arr, n, i, ind-1, dp) + cost(arr, n, ind+1, j, dp); 
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
}