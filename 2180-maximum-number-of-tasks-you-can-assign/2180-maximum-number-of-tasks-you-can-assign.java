class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left=1, right = Math.min(m,n), ans=0;
        while(left<=right){
            int mid = (left+right)/2;
            if(check(tasks, workers, pills, strength, mid)){
                ans = mid;
                left = mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid){
        int p = pills;
        int m = workers.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int ptr = m-1;

        for(int i=mid-1;i>=0;i--){
            while(ptr >= m-mid && workers[ptr]+strength >= tasks[i]){
                dq.addFirst(workers[ptr]);
                --ptr;
            }
            if(dq.isEmpty()){
                return false;
            }
            else if(dq.getLast() >= tasks[i]){
                dq.pollLast();
            }
            else{
                if(p==0){
                    return false;
                }
                --p;
                dq.pollFirst();
            }
        }
        return true;
    }
}