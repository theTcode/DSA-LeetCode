class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = checkResult(tops, bottoms, tops[0]);
        if(bottoms[0] != tops[0]){
            res = Math.min(res, checkResult(tops, bottoms, bottoms[0]));
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
    private int checkResult(int[] top, int[] bottom, int target){
        int RTop = 0, RBottom=0;
        for(int i=0;i<top.length;i++){
            if(top[i] != target && bottom[i] !=target){
                return Integer.MAX_VALUE;
            }
            if(top[i] != target) RTop++;
            if(bottom[i] != target) RBottom++;
        }
        return Math.min(RTop, RBottom);
    }
}