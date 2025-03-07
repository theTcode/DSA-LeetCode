class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right+1];
        Arrays.fill(prime, true);

        for(int i=2;i*i<=right;i++){
            if(prime[i]==true){
                for(int j=i*i;j<=right;j+=i){
                    prime[j]=false;
                }
            }
        }

        List<Integer> validPrime = new ArrayList<>();
        for(int i=2;i<=right;i++){
            if(prime[i]==true){
                validPrime.add(i);
            }
        }

        int minDiff = Integer.MAX_VALUE;
        int num1 = -1;
        int num2 = -1;

        for(int i=validPrime.size()-1;i>0;i--){
            if((validPrime.get(i)-validPrime.get(i-1))<=minDiff && validPrime.get(i-1)>=left){
                minDiff = validPrime.get(i)-validPrime.get(i-1);
                num1=validPrime.get(i-1);
                num2=validPrime.get(i);
            }
        }

        return new int[] {num1, num2};
    }
}