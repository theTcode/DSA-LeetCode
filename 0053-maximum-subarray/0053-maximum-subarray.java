class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            if(sum < 0){
                sum=0;
            }
            maxi = Math.max(maxi, sum);
        }
        if(maxi==0){
            Arrays.sort(nums);
            maxi = nums[nums.length-1];
        }
        return maxi;
    }
}