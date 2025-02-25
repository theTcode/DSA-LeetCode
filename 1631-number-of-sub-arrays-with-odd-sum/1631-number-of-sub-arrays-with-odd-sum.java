class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = (int)Math.pow(10,9)+7;
        int n = arr.length;

        for(int num=0;num<n;num++){
            arr[num] %= 2;
        }

        int[] dpEven = new int[n];
        int[] dpOdd = new int[n];

        if(arr[n-1]==0){
            dpEven[n-1]=1;
        }
        else{
            dpOdd[n-1]=1;
        }

        for(int num=n-2;num>=0;num--){
            if(arr[num]==1){
                dpOdd[num] = (1+dpEven[num+1]) % mod;
                dpEven[num] = dpOdd[num+1];
            }
            else{
                dpEven[num] = (1+dpEven[num+1]) % mod;
                dpOdd[num] = dpOdd[num+1];
            }
        }

        int count=0;
        for(int oddCount : dpOdd){
            count += oddCount;
            count %= mod;
        }
        return count;
    }
}