class Solution {
    private static int mod = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int[] nums = new int[26];
        for(char ch : s.toCharArray()){
            nums[ch - 'a']++;
        }
        while(t-- > 0){
            int[] cur = new int[26];
            for(int j=0;j<26;j++){
                if(j==25 && nums[j]>0){
                    cur[0] = modAdd(cur[0], nums[j]);
                    cur[1] = modAdd(cur[1], nums[j]);
                }
                else{
                    if(j<25){
                        cur[j+1] = modAdd(cur[j+1], nums[j]);
                    }
                }
            }
            nums = cur;
        }
        int ans = 0;
        for(int i : nums){
            ans = modAdd(ans, i);
        }
        return ans;
    }
    private int modAdd(int a, int b){
        a %= mod;
        b %= mod;
        return ((a+b)%mod + mod)%mod;
    }
}