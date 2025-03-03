class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int ind = 0;
        int sameVal = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                res[ind++]=nums[i];
            }
            if(nums[i]==pivot){
                sameVal++;
            }
        }
        for(int i=0;i<sameVal;i++){
            res[ind++]=pivot;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot){
                res[ind++]=nums[i];
            }
        }
        return res;
    }
}