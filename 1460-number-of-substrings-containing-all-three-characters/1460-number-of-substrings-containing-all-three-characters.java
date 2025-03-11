class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int l=0;
        int[] charCount = new int[3];

        for(int r=0;r<s.length();r++){
            charCount[s.charAt(r)-'a']++;

            while(charCount[0]>0 && charCount[1]>0 && charCount[2]>0){
                count+= s.length()-r;
                charCount[s.charAt(l)-'a']--;
                l++;
            }
        }
        return count;
    }
}