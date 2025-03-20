class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<int[]>> adjList = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>(2));
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(new int[]{edge[1],edge[2]});            
            adjList.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        boolean[] visited = new boolean[n];

        int[] components = new int[n];
        List<Integer> componentCost = new ArrayList<>(n);

        int componentId = 0;

        for(int node=0;node<n;node++){
            if(!visited[node]){
                componentCost.add(getComponentCost(node, adjList, visited,  components, componentId));
                componentId++;
            }
        }

        int[] answer = new int[query.length];
        for(int i=0;i<query.length;i++){
            int start = query[i][0];
            int end = query[i][1];

            if(components[start] == components[end]){
                answer[i]=componentCost.get(components[start]);
            }
            else{
                answer[i]= -1;
            }
        }
        return answer;
    }

    private int getComponentCost(int node, List<List<int[]>> adjList, boolean[] visited, int[] components, int componentId) 
    {
        int currentCost = Integer.MAX_VALUE;

        components[node] = componentId;
        visited[node] = true;

        for (int[] neighbor : adjList.get(node)) {
            int weight = neighbor[1];

            currentCost &= weight;

            if (!visited[neighbor[0]]) {
                currentCost &= getComponentCost(neighbor[0], adjList, visited, components, componentId);
            }
        }

        return currentCost;
    }
}