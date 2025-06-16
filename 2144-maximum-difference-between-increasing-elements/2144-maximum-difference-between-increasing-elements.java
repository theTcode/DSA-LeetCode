class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int diff = nums[j]-nums[i];
                if(diff>maxDiff){
                    maxDiff = diff;
                }
            }
        }
        return maxDiff==0?-1:maxDiff;
    }
}