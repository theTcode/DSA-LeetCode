class Solution {
    public int minimumIndex(List<Integer> nums) {
        int x = nums.get(0), count = 0, xCount = 0, n = nums.size();

        for (int num : nums) {
            if (num == x) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                x = num;
                count = 1;
            }
        }

        for (int num : nums) {
            if (num == x) {
                xCount++;
            }
        }

        count = 0;
        for (int index = 0; index < n; index++) {
            if (nums.get(index) == x) {
                count++;
            }
            int remainingCount = xCount - count;
            if (count * 2 > index + 1 && remainingCount * 2 > n - index - 1) {
                return index;
            }
        }
        return -1;
    }
}