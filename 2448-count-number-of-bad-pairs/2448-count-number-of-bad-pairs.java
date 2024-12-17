class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Long, Long> map = new HashMap<>();

        long count=0;
        for(int i =0;i<nums.length;i++){
            long diff = (long)nums[i]-i;
            
            count += map.getOrDefault(diff, 0L);

            map.put(diff, map.getOrDefault(diff, 0L)+1);
        }
        long total = (long)nums.length*(nums.length-1)/2;
        return total - count;
    }
}