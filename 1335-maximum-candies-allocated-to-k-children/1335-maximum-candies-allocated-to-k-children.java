class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max=candies[0];
        for(int i=1;i<candies.length;i++)
        {
            max=Math.max(candies[i],max);
        }
        int left=1,right=max;
        int ans=0;

        while(left<=right){
            int mid = (left+right)/2;
            if(valid(mid, candies, k)){
                ans = mid;
                left = mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    public boolean valid(int mid, int[] candies, long k){
        long c=0;
        for(int i=0;i<candies.length;i++)
        {
          if(candies[i]>=mid)
          {
            c+=candies[i]/mid;
          }
        }
        if(c>=k){
            return true;
        }
        return false;
    }
}