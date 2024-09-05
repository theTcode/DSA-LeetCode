class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0;
        int i=0;
        int product =1;
        for(int j=0;j<nums.length;j++){
            product = product*nums[j];
            while(i<=j && product>=k){
                product = product/nums[i];
                i++;
            }
            ans += j-i+1;
        }
        return ans;
    }
}