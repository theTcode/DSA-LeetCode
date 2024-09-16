class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int m=0;
        while(m<=j){
            if(nums[m]==0){
                swap(i, m, nums);
                m++;
                i++;
            }
            else if(nums[m]==1){
                m++;
            }
            else{
                swap(m, j, nums);
                j--;
            }
        }
    }
    public void swap(int first, int second, int[] arr){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}