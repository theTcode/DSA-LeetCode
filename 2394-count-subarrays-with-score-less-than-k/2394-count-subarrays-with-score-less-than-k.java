class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0, right=0;
        long sum = 0;
        long cnt=0;
        while(right<nums.length){
            sum += nums[right];
            while(sum*(right-left+1) >= k && left<=right){
                sum -= nums[left];
                left++;
            }
            cnt += right-left+1;
            right++;
        }
        return cnt;
    }
}