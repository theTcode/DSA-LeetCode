class Pair{
    int row;
    int col;
    int step;
    Pair(int _row, int _col, int _step){
        this.row = _row;
        this.col = _col;
        this.step = _step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int s = q.peek().step;
            q.remove();
            dist[r][c] = s;
            for(int i=0;i<4;i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol, s+1));
                }
            }
        }

        return dist;
    }
}