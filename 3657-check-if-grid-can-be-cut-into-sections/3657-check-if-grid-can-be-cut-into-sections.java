class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return cutsCheck(0, rectangles) || cutsCheck(1, rectangles);
    }
    public boolean cutsCheck(int n, int[][] rectangles){
        int cnt=0;
        Arrays.sort(rectangles, (a,b)->Integer.compare(a[n], b[n]));

        int farEnd = rectangles[0][n+2];

        for(int i=1;i<rectangles.length;i++){
            int[] rect = rectangles[i];
            if(farEnd <= rect[n]){
                cnt++;
            }

            farEnd = Math.max(farEnd, rect[n+2]);
        }

        return cnt >= 2;
    }
}