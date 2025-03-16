class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low=1, ans=0;
        int n=0;
        for(int i=0;i<ranks.length;i++){
            n = Math.max(ranks[i],n);
        }
        long high = 1L*n*cars*cars;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(isValid(ranks, cars, mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int[] ranks, int cars, long mid){
        int cnt=0;
        for(int i=0;i<ranks.length;i++){
            cnt += Math.sqrt(mid/ranks[i]);
            if(cnt >= cars){
                return true;
            }
        }
        return false;
    }
}