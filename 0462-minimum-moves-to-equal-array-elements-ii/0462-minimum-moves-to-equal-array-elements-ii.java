class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = 0;
        if(nums.length%2 != 0){
            median = nums[nums.length/2];
        }
        else{
            median = (nums[(nums.length/2)-1] + nums[nums.length/2])/2;
        }

        int steps = 0;
        for(int i=0;i<nums.length;i++){
            steps += Math.abs(nums[i]-median);
        }
        return steps;
    }
}