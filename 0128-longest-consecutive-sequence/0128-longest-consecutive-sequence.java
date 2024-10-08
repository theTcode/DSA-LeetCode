class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int maxi = 1;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1] +1){
                count=count+1;
            }
            else if(nums[i]==nums[i-1]){
                continue;
            }
            else{
                maxi = Math.max(count, maxi);
                count=1;
            }
        }
        maxi = Math.max(count, maxi);
        return maxi;
    }
}