class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int product = nums[i]*nums[j];
                int totalFreq = freqMap.getOrDefault(product, 0)+1;

                freqMap.put(product, totalFreq);
            }
        }

        int res=0;
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            int freq = entry.getValue();

            res += 4*(freq)*(freq-1);
        }
        return res;
    }
}