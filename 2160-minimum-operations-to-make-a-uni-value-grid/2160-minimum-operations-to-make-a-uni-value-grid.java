class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] gridArray = new int[grid.length*grid[0].length];
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                gridArray[i*grid[0].length + j] = grid[i][j];
            }
        }

        Arrays.sort(gridArray);
        int len = gridArray.length;
        int medianNum = gridArray[len/2];

        for(int num : gridArray){
            if(num%x != medianNum%x){
                return -1;
            }
            result += Math.abs(medianNum-num)/x;
        }
        return result;
    }
}