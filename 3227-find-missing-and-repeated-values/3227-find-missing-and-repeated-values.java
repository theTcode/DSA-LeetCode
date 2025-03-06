class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] visited = new int[n*n+1];
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[grid[i][j]]==0){
                    visited[grid[i][j]]=1;
                }
                else{
                    res.add(grid[i][j]);
                }
            }
        }
        for(int i=1;i<visited.length;i++){
            if(visited[i]==0){
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}