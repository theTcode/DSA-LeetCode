class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int l=0,r=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans=0l;
        for(int i=0;i<n;i++){
            while(l<k && r+1<n){
                ++r;
                l += map.getOrDefault(nums[r],0);
                map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            }
            if(l >= k){
                ans += n-r;
            }
            map.put(nums[i], map.get(nums[i])-1);
            l -= map.get(nums[i]);
        }
        return ans;
    }
}