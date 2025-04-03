class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefixNum = new int[n];
        int[] suffixNum = new int[n];

        prefixNum[0] = nums[0];
        suffixNum[n-1] = nums[n-1];

        for(int i=1;i<n-2;i++){
            prefixNum[i] = Math.max(nums[i], prefixNum[i-1]);
        }
        for(int i=n-2;i>1;i--){
            suffixNum[i] = Math.max(nums[i], suffixNum[i+1]);
        }

        long ans = 0l;

        for(int i=1;i<n-1;i++){
            ans = (long)Math.max(ans, (long)(prefixNum[i-1]-nums[i])*suffixNum[i+1]);
        }

        return ans;
    }
}