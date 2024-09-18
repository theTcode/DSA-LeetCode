class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        if((totalSum - target)<0 || (totalSum - target)%2 == 1){
            return 0;
        }
        return findWays((totalSum - target)/2, nums);
    }
    public int findWays(int tar, int[] arr){
        int n = arr.length;
        int[] prev = new int[tar+1];
        if(arr[0]==0){
            prev[0] = 2;
        }
        else{
            prev[0] = 1;
        }
        if(arr[0] != 0 && arr[0] <= tar){
            prev[arr[0]] = 1;
        }
        for(int i=1;i<n;i++){
            int[] cur = new int[tar+1];
            for(int j=0;j<=tar;j++){
                int notTake = prev[j];
                int take = 0;
                if(arr[i] <= j){
                    take = prev[j-arr[i]];
                }
                cur[j] = (notTake + take);
            }
            prev = cur;
        }
        return prev[tar];
    }
}