class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minPrefixTotal = 0, maxPrefixTotal = 0;
        int prefixTotal = 0;

        for(int num=0;num<nums.length;num++){
            prefixTotal += nums[num];

            minPrefixTotal = Math.min(minPrefixTotal, prefixTotal);
            maxPrefixTotal = Math.max(maxPrefixTotal, prefixTotal);
        }

        return maxPrefixTotal - minPrefixTotal;
    }
}