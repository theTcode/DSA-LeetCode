class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return sum(0, arr, k, dp);
    }
    public int sum(int ind, int[] arr, int k, int[] dp){
        if(ind == arr.length){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int maxNum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int len=0;
        for(int j=ind;j<Math.min(arr.length, ind+k);j++){
            len++;
            maxNum = Math.max(maxNum, arr[j]);
            int sum = len*maxNum + sum(j+1, arr, k, dp);
            max = Math.max(max, sum);
        }
        return dp[ind] = max;
    }
}