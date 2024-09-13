class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] front = new int[c][c];
        int[][] curr = new int[c][c];

        for(int j1=0;j1<c;j1++){
            for(int j2=0;j2<c;j2++){
                if(j1==j2){
                    front[j1][j2] = grid[r-1][j1];
                }
                else{
                    front[j1][j2] = grid[r-1][j1] + grid[r-1][j2];
                }
            }
        }

        for(int i=r-2;i>=0;i--){
            for(int j1=0;j1<c;j1++){
                for(int j2=0;j2<c;j2++){
                    int maxi = Integer.MIN_VALUE;
                    for(int dj1=-1;dj1 <= 1;dj1++){
                        for(int dj2=-1;dj2 <= 1;dj2++){
                            int value=0;
                            if(j1==j2){
                                value = grid[i][j1];
                            }
                            else{
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if(j1+dj1>=0 && j1+dj1<c && j2+dj2>=0 && j2+dj2<c){
                                value += front[j1+dj1][j2+dj2];
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            for (int a = 0; a < c; a++) {
                front[a] = curr[a].clone();
            }
        }
        return front[0][c-1];
    }
}