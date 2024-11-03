class Solution {
    public boolean rotateString(String s, String goal) {
        //Approach-1

        // String str = "";
        // for(int i=0;i<s.length();i++){
        //     str = s.substring(i+1, s.length()) + s.substring(0,i+1);
        //     if(str.equals(goal)){
        //         return true;
        //     }
        // }
        // return false;

        // Approach-2

        if(s.length() != goal.length()){
            return false;
        }

        String doubled = s+s;

        return doubled.contains(goal);
    }
}