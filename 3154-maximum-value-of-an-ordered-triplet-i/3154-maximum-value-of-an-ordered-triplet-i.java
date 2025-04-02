class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0l;
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    res = (long)Math.max(res, (long)(nums[i]-nums[j])*nums[k]);
                    // if(ans>res){
                    //     res = ans;
                    // }
                }
            }
        }

        return res;
    }
}