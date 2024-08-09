class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> string1 = new Stack<>();
        Stack<Character> string2 = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='#' && !string1.isEmpty()){
                string1.pop();
                continue;
            }
            if(s.charAt(i)=='#' && string1.isEmpty()){
                continue;
            }
            string1.push(s.charAt(i));
        }
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i)=='#' && !string2.isEmpty()){
                string2.pop();
                continue;
            }
            if(t.charAt(i)=='#' && string2.isEmpty()){
                continue;
            }
            string2.push(t.charAt(i));
        }

        while(!string1.isEmpty() && !string2.isEmpty()){
            if(string1.pop() != string2.pop()){
                return false;
            }
        }
        return string1.isEmpty() && string2.isEmpty();
    }
}