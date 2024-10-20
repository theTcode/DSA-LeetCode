class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        String ans = "";
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        int i=0, j=0;
        int min = Integer.MAX_VALUE;
        int count = map.size();
        while(j<s.length()){
            if(count>0){
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j))-1);
                    if(map.get(s.charAt(j))==0){
                        count--;
                    }
                }
            }
            if(count==0){
                while(count==0){
                    if((j-i+1)<min){
                        min = j-i+1;
                        ans = s.substring(i, j+1);
                    }
                    // min = Math.min(min, j-i+1);
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i), map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i))>0){
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}