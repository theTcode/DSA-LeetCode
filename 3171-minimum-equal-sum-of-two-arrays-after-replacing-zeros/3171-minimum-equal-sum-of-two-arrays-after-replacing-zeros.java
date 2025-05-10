class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        long cntZ1 = 0, cntZ2=0;
        long sum1=0, sum2=0;
        for(int i=0;i<n;i++){
            if(nums1[i]==0){
                cntZ1++;
            }
            else{
                sum1 += nums1[i];
            }
        }
        for(int i=0;i<m;i++){
            if(nums2[i]==0){
                cntZ2++;
            }
            else{
                sum2 += nums2[i];
            }
        }
        if((sum1+cntZ1>sum2 && cntZ2==0) || (sum2+cntZ2>sum1 && cntZ1==0)){
            return -1;
        }
        return (long)Math.max(sum1+cntZ1, sum2+cntZ2);
    }
}