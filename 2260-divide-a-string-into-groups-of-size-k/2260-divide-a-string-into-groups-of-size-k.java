class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = (s.length() + k - 1)/k;
        
        String[] ans = new String[len];

        for(int i=0;i<s.length();i+=k){
            if(i+k <= s.length()){
                ans[i/k] = s.substring(i,i+k);
            }
            else{
                StringBuilder sb = new StringBuilder(s.substring(i));
                while (sb.length() < k) {
                    sb.append(fill);
                }
                ans[i / k] = sb.toString();
            }
        }

        return ans;
    }
}