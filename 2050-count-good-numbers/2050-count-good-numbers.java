class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        return (int)((quickMultiply(5, (n+1)/2) * quickMultiply(4, n/2)) % MOD);
    }

    public long quickMultiply(int a, long b){
        long valReturn = 1;
        long multiply = a;
        while(b>0){
            if(b % 2 == 1){
                valReturn = (valReturn * multiply) % MOD;
            }
            multiply = (multiply * multiply) % MOD;
            b /= 2;
        }
        return valReturn;
    }
}