class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0;i<n;i++){
            if(i != 0) arr1[i] = nums[i];
            if(i != n-1) arr2[i] = nums[i];
        }
        return Math.max(houses(arr1), houses(arr2));
    }
    private int houses(int[] arr){
        int n=arr.length;
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int loot = arr[i];
            if(i>1) loot += prev2;
            int notLoot = 0+ prev;

            int curr = Math.max(loot, notLoot);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}