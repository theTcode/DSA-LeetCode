class Solution {
    public String smallestNumber(String pattern) {
        int top=0, s[] = new int[10], n=pattern.length();
        StringBuilder result = new StringBuilder();
        s[0]=1;
        for(int place=0;place<n;place++){
            if(pattern.charAt(place) == 'I'){
                while(top>=0){
                    result.append(s[top--]);
                }
            }
            s[++top]=place+2;
        }
        while(top>=0){
            result.append(s[top--]);
        }
        return result.toString();
    }
}