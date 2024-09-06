class Solution {
    public boolean canJump(int[] nums) {
        int place, j=0;
        int max = 0;
        while(j<nums.length){
            place = max;
            if(j>place){
                return false;
            }
            for(int i=j; i<=place; i++){
                max = Math.max(max, i+nums[i]);
                if(max >= nums.length-1){
                    return true;
                }
            }
            j=place+1;
        }
        return false;
    }
}