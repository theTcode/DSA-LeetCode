class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int)1e9 +7;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int startNode = road[0], endNode=road[1], travelNode=road[2];
            graph.get(startNode).add(new int[]{endNode, travelNode});
            graph.get(endNode).add(new int[]{startNode, travelNode});
        }

        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        long[] sTime = new long[n];
        Arrays.fill(sTime, Long.MAX_VALUE);
        int[] pathCount = new int[n];

        sTime[0]=0;
        pathCount[0] = 1;

        minHeap.offer(new long[]{0,0});

        while (!minHeap.isEmpty()) {
            long[] top = minHeap.poll();
            long currTime = top[0];
            int currNode = (int) top[1];

            if (currTime > sTime[currNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int neighborNode = neighbor[0], roadTime = neighbor[1];

                if (currTime + roadTime < sTime[neighborNode]) {
                    sTime[neighborNode] = currTime + roadTime;
                    pathCount[neighborNode] = pathCount[currNode];
                    minHeap.offer(
                        new long[] { sTime[neighborNode], neighborNode }
                    );
                }
                else if (currTime + roadTime == sTime[neighborNode]) {
                    pathCount[neighborNode] =
                        (pathCount[neighborNode] + pathCount[currNode]) % MOD;
                }
            }
        }

        return pathCount[n - 1];
    }
}