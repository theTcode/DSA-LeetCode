class Solution {
    public int removeDuplicates(int[] nums) {
        int count =1;
        if(nums.length==1){
            return count;
        }

        int p1=0, p2=1;

        while(p2<nums.length){
            if(nums[p1]==nums[p2]){
                p2++;
            }
            else{
                p1++;
                swap(nums, p1, p2);
                count++;
                p2++;
            }
        }
        return count;
    }
    void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}