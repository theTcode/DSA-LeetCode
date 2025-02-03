class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int inc = strIncr(nums);
        int dec = strDecr(nums);

        int max = Math.max(inc, dec);
        return max;
    }
    public int strIncr(int[] nums){
        int count = 1;
        int max = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]){
                count++;
                max = Math.max(max, count);
            }
            else{
                count=1;
            }
        }
        return max;
    }
    public int strDecr(int[] nums){
        int count = 1;
        int max = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]<nums[i]){
                count++;
                max = Math.max(max, count);
            }
            else{
                count=1;
            }
        }
        return max;
    }
}