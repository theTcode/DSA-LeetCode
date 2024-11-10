class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(int row, int col, int[][] vis, char[][] grid){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int k=0;k<4;k++){
                int newRow = r+delrow[k];
                int newCol = c+delcol[k];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m
                    && grid[newRow][newCol]=='1' && vis[newRow][newCol]==0){
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}