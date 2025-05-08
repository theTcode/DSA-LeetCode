class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
           Arrays.fill(row, Integer.MAX_VALUE); 
        }  
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,0,0,0});
        moveTime[0][0] = 0;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currTime = current[0];
            int currRow = current[1];
            int currCol = current[2];
            int nextMoveTime = current[3];
            if(currTime >= dp[currRow][currCol]){
                continue;
            }
            dp[currRow][currCol] = currTime;
            if(currRow == n-1 && currCol == m-1){
                return currTime;
            }
            for(int[] dir : directions){
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){
                    int wait = moveTime[nextRow][nextCol];
                    int futureMove = nextMoveTime == 1?2:1;
                    int nextTime = wait > currTime ? wait + futureMove : currTime + futureMove;

                    if(currRow==0 && currCol==0 && wait <= currTime){
                        nextTime = wait + futureMove;
                    }
                    if(nextTime < dp[nextRow][nextCol]){
                        pq.add(new int[]{nextTime, nextRow, nextCol, futureMove});
                    }
                    
                }
            }
        }
        return -1;
    }
}