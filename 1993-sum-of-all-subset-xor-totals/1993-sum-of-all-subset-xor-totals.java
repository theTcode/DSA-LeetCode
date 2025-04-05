class Solution {
    public int subsetXORSum(int[] nums) {
        return XORSum(nums, 0, 0);
    }
    private int XORSum(int[] nums, int index, int currXOR){
        if(index == nums.length){
            return currXOR;
        }

        int withElement = XORSum(nums, index+1, currXOR^nums[index]);
        int withoutElement = XORSum(nums, index+1, currXOR);

        return withElement + withoutElement;
    }
}