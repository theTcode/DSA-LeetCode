class Solution {
    public String digitSum(String s, int k) {
        if(s.length() <= k){
            return s;
        }
        List<String> arr = new ArrayList<>();
        for(int i=0;i*k<s.length();i++){
            int end = Math.min(i*k+k,s.length());
            arr.add(s.substring(i*k,end));
        }
        for(int j=0;j<arr.size();j++){
            String val = arr.get(j);
            int res = 0;
            for(int add=0;add<val.length();add++){
                res += Integer.parseInt(String.valueOf(val.charAt(add)));
            }
            arr.set(j,String.valueOf(res));
        }
        String result = "";
        for(int x=0;x<arr.size();x++){
            result += arr.get(x);
        }
        return digitSum(result,k);
    }
}