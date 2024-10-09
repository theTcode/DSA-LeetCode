class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 1;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for(int ind=0;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(nums[prev]<nums[ind] && 1+dp[prev]>dp[ind]){
                    dp[ind] = Math.max(dp[ind], 1+dp[prev]);
                    cnt[ind] = cnt[prev];
                }
                else if(nums[prev]<nums[ind] && 1+dp[prev]==dp[ind]){
                    cnt[ind] += cnt[prev];
                }
                maxi = Math.max(maxi, dp[ind]);
            }
        }
        int num = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                num += cnt[i];
            }
        }
        return num;
    }
}