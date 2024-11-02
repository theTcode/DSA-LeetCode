class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m  = queries.length;
        if(n==1 && m==1){
            return new boolean[] {true};
        }
        int[] check  =  new int[n];
        int count = 0;
        for(int i=1;i<n;i++){
            if(nums[i]%2 == nums[i-1]%2){
                count++;
            }
            check[i]=count;
        }

        boolean[] result = new boolean[m];
        int ind = 0;
        for(int[] arr : queries){
            int mistakes = check[arr[1]] - check[arr[0]];
            if(mistakes==0){
                result[ind]=true;
            }
            ind++;
        }
        return result;
    }
}