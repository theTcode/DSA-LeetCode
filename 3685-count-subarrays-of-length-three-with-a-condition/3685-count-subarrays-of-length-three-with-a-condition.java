class Solution {
    public int countSubarrays(int[] nums) {
        int left = 0;
        int right = 2;

        int cnt = 0;
        while((right-left)==2 && right<nums.length){
            if(2*(nums[right]+nums[left]) == nums[right-1]){
                cnt++;
            }
            left++;
            right++;
        }
        return cnt;
    }
}