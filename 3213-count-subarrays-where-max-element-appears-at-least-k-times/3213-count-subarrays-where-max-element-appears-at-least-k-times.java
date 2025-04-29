class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxElement){
                maxElement=nums[i];
            }
        }
        long ans = 0, start=0;
        int maxValsInSubArray=0;

        for(int end=0;end<nums.length;end++){
            if(nums[end]==maxElement){
                maxValsInSubArray++;
            }
            while(maxValsInSubArray == k){
                if(nums[(int)start]==maxElement){
                    maxValsInSubArray--;
                }
                start++;
            }
            ans += start;
        }
        return ans;
    }
}