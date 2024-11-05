class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] word = sentence.trim().split(" ");
        int n = word.length;
        for(int i=0;i<n;i++){
            if(word[i].charAt((word[i]).length()-1)!=word[(i+1)%n].charAt(0)){
                return false;
            }
        }
        return true;
    }
}