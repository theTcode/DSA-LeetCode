class Solution {
    public long coloredCells(int n) {
        long totalcc =1;
        if(n==1){
            return totalcc;
        }
        for(long i=1;i<n;i++){
            totalcc += 4*i;
        }
        return totalcc;
    }
}