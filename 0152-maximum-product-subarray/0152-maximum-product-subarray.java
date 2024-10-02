class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int maxSoFar = nums[0];

        for(int i=1;i<nums.length;i++){
            int current = nums[i];

            if(current<0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(current, max*current);
            min = Math.min(current, min*current);

            maxSoFar = Math.max(max, maxSoFar);
        }
        return maxSoFar;
    }
}