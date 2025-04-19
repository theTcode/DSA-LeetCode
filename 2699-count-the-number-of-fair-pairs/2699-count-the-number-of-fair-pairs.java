class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long cnt = 0;
        for(int i=0; i<nums.length; i++){
            long low = helper(nums, i+1, nums.length-1,lower-nums[i]);
            long high = helper(nums, i+1, nums.length-1, upper-nums[i]+1);

            cnt += 1*(high-low);
        }
        return cnt;
    }
    private long helper(int[] nums, int low, int high, int element){
        while(low <= high){
            int mid = low + ((high-low)/2);
            if(nums[mid] >= element){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}