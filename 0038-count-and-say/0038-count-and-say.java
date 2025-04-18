class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++){
            res = help(res);
        }
        return res;
    }
    private String help(String str){
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        for(int i=1; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                cnt++;
            }
            else{
                sb.append(cnt).append(str.charAt(i-1));
                cnt = 1;
            }
        }

        sb.append(cnt).append(str.charAt(str.length()-1));
        return sb.toString();
    }
}