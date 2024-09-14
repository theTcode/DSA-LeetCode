class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 !=0){
            return false;
        }
        int target = totalSum/2;
        return subset(nums, nums.length, target);
    }
    private boolean subset(int[] num, int n, int target){
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 
        for (int nums : num) {
            for (int j=target;j>=nums;j--) {
                dp[j] = dp[j]||dp[j-nums];
            }
        }

        return dp[target];
    }
}