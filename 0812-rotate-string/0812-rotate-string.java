class Solution {
    public boolean rotateString(String s, String goal) {
        String str = "";
        for(int i=0;i<s.length();i++){
            str = s.substring(i+1, s.length()) + s.substring(0,i+1);
            if(str.equals(goal)){
                return true;
            }
        }
        return false;
    }
}