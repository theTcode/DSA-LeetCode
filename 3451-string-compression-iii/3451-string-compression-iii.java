class Solution {
    public String compressedString(String word) {
        String comp = "";
        if(word.length()==1){
            comp += "1";
            comp += word;
            return comp;
        }
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
            comp += Integer.toString(count);
            comp += String.valueOf(ch);
            j++;
        }
        return comp;
    }
}