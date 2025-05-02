class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] idxs = new int[n+2];
        char[] symbls = new char[n+2];
        int len = 1;
        idxs[0] = -1;
        symbls[0] = 'L';

        for(int i=0;i<n;i++){
            if(dominoes.charAt(i) != '.'){
                idxs[len] = i;
                symbls[len++] = dominoes.charAt(i);
            }
        }
        idxs[len] = n;
        symbls[len++] = 'R';

        char[] ans = dominoes.toCharArray();
        for(int index = 0;index<len-1;index++){
            int i = idxs[index], j=idxs[index+1];
            char x = symbls[index],  y=symbls[index+1];
            char write;
            if(x == y){
                for(int k=i+1;k<j;k++){
                    ans[k] = x;
                }
            }
            else if(x>y){
                for(int k = i+1;k<j;k++){
                    ans[k] = k-i == j-k ? '.' : k-i<j-k ? 'R':'L';
                }
            }
        }
        return String.valueOf(ans);
    }
}