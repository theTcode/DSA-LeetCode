class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int j = 0;
        while(j<word.length()){
            int count = 1;
            char ch = word.charAt(j);
            while(j+1< word.length() && word.charAt(j) == word.charAt(j+1)){
                if(count == 9){
                    break;
                }
                j++;
                count++;
            }
            comp.append(count).append(ch);
            j++;
        }
        return comp.toString();
    }
}