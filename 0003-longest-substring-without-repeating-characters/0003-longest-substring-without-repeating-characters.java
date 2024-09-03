class Solution {

    //Approach-1
    public int lengthOfLongestSubstring(String s) {
        int max=0, length=0, i=0, j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            if(map.size()==j-i+1){
                length=j-i+1;
                if(length>max){
                    max=length;
                }
            }
            if(map.size()<j-i+1){
                while(map.size()!=j-i+1){
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    //Approach-2
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for(int right=0;right<s.length();right++){
            char currChar = s.charAt(right);

            if(map.containsKey(currChar)){
                left = Math.max(map.get(currChar)+1, left);
            }

            map.put(currChar, right);

            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}
