class Solution {
    public long putMarbles(int[] weights, int k) {
        int len = weights.length;
        int[] coupleWeight = new int[len-1];

        for(int i=0;i<len-1;++i){
            coupleWeight[i]=weights[i]+weights[i+1];
        }

        Arrays.sort(coupleWeight, 0, len-1);

        long answer = 0l;
        for(int i=0;i<k-1;++i){
            answer += coupleWeight[len-2-i] - coupleWeight[i];
        }

        return answer;
    }
}