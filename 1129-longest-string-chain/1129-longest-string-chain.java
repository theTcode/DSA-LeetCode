class Solution {
    public boolean check(String a, String b){
        if(a.length() != b.length()+1){
            return false;
        }
        int first=0;
        int second=0;
        boolean foundDiff = false;
        while(first<a.length() && second < b.length()){
            if(a.charAt(first) == b.charAt(second)){
                first++;
                second++;
            }
            else{
                if(foundDiff){
                    return false;
                }
                foundDiff = true;
                first++;
            }
        }
        // if(first == a.length() && second == b.length()){
        //     return true;
        // }
        return true;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[i], words[j]) && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}