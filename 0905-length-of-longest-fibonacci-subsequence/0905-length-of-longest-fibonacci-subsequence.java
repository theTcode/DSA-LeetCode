class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxLength = 0;
        int n = arr.length;
        int[][] dp = new int[n][n];

        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        for(int curr=0;curr < n;curr++){
            valToIndex.put(arr[curr],curr);
            for(int prev=0;prev < curr;prev++){
                int diff = arr[curr]-arr[prev];
                int prevIndex = valToIndex.getOrDefault(diff, -1);

                if(diff < arr[prev] && prevIndex >= 0){
                    dp[prev][curr] = dp[prevIndex][prev] + 1;
                }
                else{
                    dp[prev][curr] = 2;
                }

                maxLength = Math.max(maxLength, dp[prev][curr]);
            }
        }

        return maxLength>2 ? maxLength : 0;
    }
}