class Solution {
    public int minimumMountainRemovals(int[] nums) {
        return nums.length - lis(nums, nums.length);
    }
    private int lis(int[] nums, int n){
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for(int ind=0;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(nums[prev]<nums[ind]){
                    dp1[ind] = Math.max(dp1[ind], 1+dp1[prev]);
                }
            }
        }

        int[] dp2 = new int[n];
        int maxi=0;
        Arrays.fill(dp2, 1);
        for(int ind=n-2;ind>=0;ind--){
            for(int prev=n-1;prev>ind;prev--){
                if(nums[prev]<nums[ind]){
                    dp2[ind] = Math.max(dp2[ind], 1+dp2[prev]);
                }
            }
            if (dp1[ind] > 1 && dp2[ind] > 1) {
                maxi = Math.max(maxi, dp1[ind] + dp2[ind] - 1);
            }
        }
        return maxi;
    }
}