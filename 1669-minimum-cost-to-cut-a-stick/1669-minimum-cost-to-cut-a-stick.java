class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        Arrays.sort(cuts);
        // new Array to calculate the cost for according to length of stick
        int[] newCut = new int[cuts.length + 2];

        // Filling the values in the new Array
        newCut[0] = 0;
        for(int i=0;i<cuts.length;i++){
            newCut[i+1] = cuts[i];
        }
        newCut[newCut.length-1] = n;

        // Memoized array for storing calculated results
        int[][] dp = new int[c+1][c+1]; 
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        //Recursive function
        return cost(newCut, n, 1, c, dp);
    }
    public int cost(int[] arr, int n, int i, int j, int[][] dp){
        int mini = Integer.MAX_VALUE;

        if(i>j){
            return 0;
        }
        //Returning the calculated result
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //Checking cost for every value
        for(int ind=i;ind<=j;ind++){
            int cost = (arr[j+1]-arr[i-1]) + cost(arr, n, i, ind-1, dp) + cost(arr, n, ind+1, j, dp); 
            mini = Math.min(mini, cost);
        }
        //Storing the calculated result
        return dp[i][j] = mini;
    }
}