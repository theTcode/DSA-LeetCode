class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        allPart(0, s, s.length(), res, new ArrayList<>());
        return res;
    }
    public void allPart(int index, String s, int n, List<List<String>> result, List<String> ans){
        if(index == n){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i=index;i<n;i++){
            if(palindrome(index, i, s)){
                ans.add(ans.size(), s.substring(index, i+1));
                allPart(i+1,s,n,result,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    private boolean palindrome(int i, int j, String c){
        while(i<=j){
            if(c.charAt(i) != c.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}