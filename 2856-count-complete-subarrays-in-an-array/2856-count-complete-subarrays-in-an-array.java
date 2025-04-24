class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int right = 0;
        int distVals = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size();

        for(int left=0;left<n;left++){
            if(left>0){
                int remove = nums[left-1];
                map.put(remove, map.get(remove)-1);
                if(map.get(remove)==0){
                    map.remove(remove);
                }
            }
            while(right < n && map.size() < distVals){
                int add = nums[right];
                map.put(add, map.getOrDefault(add,0)+1);
                right++;
            }
            if(map.size() == distVals){
                ans += (n-right+1);
            }
        }
        return ans;
    }
}