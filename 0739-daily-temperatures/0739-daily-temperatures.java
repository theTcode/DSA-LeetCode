class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int num = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < num){
                ans[stack.peek()]= i - stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}