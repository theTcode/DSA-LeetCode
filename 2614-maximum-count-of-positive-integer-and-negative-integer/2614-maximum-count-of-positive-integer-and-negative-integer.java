class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        if(nums[0]==0 && nums[n-1]==0){
            return 0;
        }
        if(nums[0]>0 || nums[n-1]<0){
            return n;
        }

        int firstPositive = -1;
        int firstNegative = -1;
        int i=0,j=n-1;

        // find first negative index
        while(i<=j) {
            int mid = (i + j) / 2;
            if (nums[mid] < 0) {
                firstNegative=mid;
                i = mid+1;
            } 
            else {
                j = mid - 1;
            }
        }

        //find first positive index
        j=n-1;
        i=0;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]>0){
                firstPositive=mid;
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        int max = 0;
        if(firstPositive>=0 && (firstNegative+1)>=0){
            max = Math.max(n-firstPositive, firstNegative+1);
        }
        else{
            return firstNegative>=0 ? firstNegative+1 : n-firstPositive;
        }
        
        return max;
    }
}