class Solution {
    public String convert(String s, int numRows) {
        String[] list = new String[numRows];
        Arrays.fill(list, "");
        int n=0;
        while(n<s.length()){
            for(int j=0;j<numRows;j++){
                if(n>=s.length()){
                    break;
                }
                list[j] += s.charAt(n);
                n++;
            }
            for(int j=numRows-2;j>0;j--){
                if(n>=s.length()){
                    break;
                }
                list[j] += s.charAt(n);
                n++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(String one : list){
            ans.append(one);
        }
        return ans.toString();
    }
}