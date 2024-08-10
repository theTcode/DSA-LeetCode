class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;

        for(int num: nums){
            sum += num;
            int diff = sum - k;
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}