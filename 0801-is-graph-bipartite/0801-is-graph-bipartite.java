class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(bfs(i, color, graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int start, int[] color, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Check all adjacent nodes
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) { // If neighbor is uncolored, color it with opposite color
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // If neighbor has the same color, the graph is not bipartite
                }
            }
        }
        return true;
    }
}