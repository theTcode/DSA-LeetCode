class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int max = -1;
        for(int i=1;i<nums.length;i++){
            max = Math.max(max, sum);
            if(nums[i]>nums[i-1]){
                sum += nums[i];
            }
            else{
                sum = nums[i];
            }
        }
        max = Math.max(sum, max);
        return max;
    }
}