class Pair{
    int row;
    int col;
    int tm;
    Pair(int _row, int _col, int _tm){
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        int[][] vis = new int[n][m];
        int countFresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }

        int tm=0;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        int count=0;
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().tm;
            tm = Math.max(tm, t);
            queue.remove();
            for(int i=0;i<4;i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if(count != countFresh){
            return -1;
        }
        return tm;
    }
}