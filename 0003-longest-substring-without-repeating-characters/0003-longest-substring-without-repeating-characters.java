class Solution {
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
}