class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, j=0;
        for(int i=0;i<nums.length && j<nums.length;i++){
            int min = nums[j];
            int max = nums[j]+k;
            if(nums[i]<=max){
                continue;
            }
            else{
                j=i;
                count++;
            }
        }
        return count+1;
    }
}