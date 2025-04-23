class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxVal = 0;
        for(int i=1;i<=n;i++){
            int key = 0, j=i;
            while(j != 0){
                key += j%10;
                j /= 10;
            }
            map.put(key, map.getOrDefault(key, 0)+1);
            maxVal = Math.max(maxVal, map.get(key));
        }

        int cnt= 0;
        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            if(pair.getValue()==maxVal){
                cnt++;
            }
        }
        return cnt;
    }
}