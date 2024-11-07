class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjLs = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            adjLs.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int[] vis = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count++;
                dfs(i, adjLs, vis);
            }
        } 
        return count;
    }
    private void dfs(int node, List<List<Integer>> adjLs, int[] vis){
        vis[node] = 1;
        for(Integer i : adjLs.get(node)){
            if(vis[i]==0){
                dfs(i, adjLs, vis);
            }
        }
    }
}