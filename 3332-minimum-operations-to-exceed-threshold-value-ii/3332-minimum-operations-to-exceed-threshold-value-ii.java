class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add((long)num);
        }

        int op = 0;

        while(queue.peek()<k){
            long x = queue.poll();
            long y = queue.poll();

            queue.add((long)Math.min(x,y)*2 + (long)Math.max(x,y));

            op++;
        }
        return op;
    }
}