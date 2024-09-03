class Solution {
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