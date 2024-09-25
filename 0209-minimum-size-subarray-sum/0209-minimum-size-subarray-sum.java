class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int totSum = 0;
        int min = Integer.MAX_VALUE;
        for(int end=0;end<nums.length;end++){
            totSum += nums[end];
            while(totSum>=target){
                min = Math.min(min, end-start+1);
                totSum -= nums[start];
                start++;
            }
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }
}