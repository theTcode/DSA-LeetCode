class Solution {
    public int countDays(int days, int[][] meetings) {
        // Approach-1 

        // int[] visited = new int[days+1];
        // int size = meetings.length, n=0;
        // while(n<size){
        //     int start = meetings[n][0];
        //     int end = meetings[n][1];
        //     for(int i=start;i<=end;i++){
        //         visited[i]=1;
        //     }
        //     n++;
        // }

        // int count=0;
        // for(int i=1;i<visited.length;i++){
        //     if(visited[i]==0){
        //         count++;
        //     }
        // }
        // return count;
        

        //Appraoch-2

        int free = 0, latestEnd=0;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for(int[] meeting: meetings){
            int start=meeting[0], end=meeting[1];

            if(start>latestEnd+1){
                free += start-latestEnd-1;
            }

            latestEnd = Math.max(latestEnd, end);
        }

        free += days-latestEnd;

        return free;
    }
}