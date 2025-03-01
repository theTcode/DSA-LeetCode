class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int countZero = 0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1]=0;
            }
            if(nums[i]==0){
                countZero++;
            }
        }

        for(int x=0;x<countZero;x++){
            for(int y=0;y<n-1;y++){
                if(nums[y]==0){
                    int temp = nums[y];
                    nums[y]=nums[y+1];
                    nums[y+1]=temp;
                }
            }
        }
        return nums;
    }
}