class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l=0, usedBits=0, maxLength=0;

        for(int i=0;i<nums.length;i++){
            while((usedBits & nums[i]) != 0){
                usedBits ^= nums[l];
                l++;
            }

            usedBits |= nums[i];
            maxLength = Math.max(maxLength, i-l+1);
        }

        return maxLength;
    }
}