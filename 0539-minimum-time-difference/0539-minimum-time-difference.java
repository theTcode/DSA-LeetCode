class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] time = new int[n];
        for(int i=0;i<n;i++){
            String s = timePoints.get(i);
            int hour = Integer.parseInt(s.substring(0,2));
            hour = hour*60;
            int mint = Integer.parseInt(s.substring(3,5));
            int total = hour + mint;
            time[i] = total;
        }
        Arrays.sort(time);
        int mini=Integer.MAX_VALUE;
        boolean zero = false;
        if(time[0]==0){
            zero = true;
        }
        for(int i=1;i<n;i++){
            mini = Math.min(mini, time[i]-time[i-1]);
        }
        mini = Math.min(mini, 1440-time[n-1]+time[0]);
        return mini;
    }
}