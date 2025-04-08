class Solution {

    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i += 3, ans++) {
            if (checkUnique(nums, i)) {
                return ans;
            }
        }
        return ans;
    }

    private boolean checkUnique(int[] nums, int start) {
        HashSet<Integer> count = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (count.contains(nums[i])) {
                return false;
            }
            count.add(nums[i]);
        }
        return true;
    }
}