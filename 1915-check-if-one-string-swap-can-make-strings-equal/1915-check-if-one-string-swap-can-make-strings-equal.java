class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int index1 = -1;
        int index2 = -1;
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i)){
                continue;
            }
            else{
                count++;
                index1 = index2;
                index2 = i;
            }
        }

        return count==0 || (count==2 && s1.charAt(index1)==s2.charAt(index2) && s1.charAt(index2)==s2.charAt(index1));
    }
}