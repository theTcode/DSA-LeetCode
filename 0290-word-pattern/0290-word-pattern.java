class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> seen = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(arr[i])){
                    return false;
                }
            }
            else{
                if(seen.contains(arr[i])){
                    return false;
                }
                map.put(ch, arr[i]);
                seen.add(arr[i]);
            }
        }
        return true;
    }
}