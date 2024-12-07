class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        // traverse the numbers from starting till its square
        for(int i=2;i*i<=n;i++){
            if(prime[i]==true){
                // if the number is not traversed then traverse its multiples to eliminate them
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }

        int count=0;
        for(int i=2;i<=n;i++){
            if(prime[i]==true){
                count++;
            }
        }

        if(prime[n]==true && n>=2){
            return count-1;
        }
        return count;
    }
}