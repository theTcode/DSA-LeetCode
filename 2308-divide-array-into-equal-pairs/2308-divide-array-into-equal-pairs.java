class Solution {
    public boolean divideArray(int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        // }

        // for(int cnt : map.values()){
        //     if((cnt & 1) == 1){
        //         return false;
        //     }
        // }

        Set<Integer> notAPair = new HashSet<>();
        for(int num: nums){
            if(notAPair.contains(num)){
                notAPair.remove(num);
            }
            else{
                notAPair.add(num);
            }
        }

        return notAPair.isEmpty();
    }
}