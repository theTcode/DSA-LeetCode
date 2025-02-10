class Solution {
    public String clearDigits(String s) {
        int ind = 0;

        StringBuilder sb = new StringBuilder(s);

        while(ind < sb.length()){
            if(Character.isDigit(sb.charAt(ind))){
                sb.deleteCharAt(ind);
                if(ind>0){
                    sb.deleteCharAt(ind-1);
                    ind--;
                }
            }
            else{
                ind++;
            }
        }
        return sb.toString();
    }
}