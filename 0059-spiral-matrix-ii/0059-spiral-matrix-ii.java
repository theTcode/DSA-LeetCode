class Solution {
    public int[][] generateMatrix(int n) {
        int a = 1;
        int[][] matrix = new int[n][n];

        int top=0,left=0;
        int bottom=n-1, right=n-1;

        while(top<=bottom && left<=right){
            //top
            for(int i=left;i<=right;i++){
                matrix[top][i] = a;
                a++;
            }
            top++;

            //right
            for(int i=top;i<=bottom;i++){
                matrix[i][right] = a;
                a++;
            }
            right--;

            //bottom
            for(int i=right;i>=left;i--){
                matrix[bottom][i] = a;
                a++;
            }
            bottom--;

            //left
            for(int i=bottom;i>=top;i--){
                matrix[i][left] = a;
                a++;
            }
            left++;
        }
        
        return matrix;
    }
}