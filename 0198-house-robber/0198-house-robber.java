class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return f(nums, nums.length-1, dp);
    }
    private int f(int[] nums, int ind, int[] dp){
        if(ind<0){
            return 0;
        }
        if(ind==0){
            return nums[ind];
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = nums[ind] + f(nums, ind-2, dp);
        int notPick = 0 + f(nums, ind-1, dp);
        return dp[ind] = Math.max(pick, notPick);
    }
}