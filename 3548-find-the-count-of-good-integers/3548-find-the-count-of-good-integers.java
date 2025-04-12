class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> dic = new HashSet<>();
        int base = (int) Math.pow(10, (n-1)/2);
        int skip = n&1;

        for(int i=base;i<base*10;i++){
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);

            if(palindromicInteger % k == 0){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dic.add(new String(chars));
            }
        }

        long[] fact = new long[n+1];
        fact[0] = 1;
        for(int i=1;i<=n;i++){
            fact[i] = fact[i-1]*i;
        }
        long ans = 0;
        for(String s : dic){
            int[] cnt = new int[10];
            for(char c : s.toCharArray()){
                cnt[c-'0']++;
            }

            long tot = (n-cnt[0]) * fact[n-1];
            for(int x : cnt){
                tot /= fact[x];
            }
            ans += tot;
        }
        return ans;
    }
}