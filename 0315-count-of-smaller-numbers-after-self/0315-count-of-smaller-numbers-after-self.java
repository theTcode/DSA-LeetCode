class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(nums.length, 0));
        
        // Create an array of pairs: (value, index)
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        
        // Perform merge sort and count during the merge step
        Integer[] temp = new Integer[nums.length];
        mergeSortHelper(nums, indices, temp, 0, nums.length - 1, result);
        
        return result;
    }
    private void mergeSortHelper(int[] nums, Integer[] indices, Integer[] temp, int left, int right, List<Integer> result) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        
        // Recursively sort the left and right halves
        mergeSortHelper(nums, indices, temp, left, mid, result);
        mergeSortHelper(nums, indices, temp, mid + 1, right, result);
        
        // Merge the two sorted halves
        merge(nums, indices, temp, left, mid, right, result);
    }

    private void merge(int[] nums, Integer[] indices, Integer[] temp, int left, int mid, int right, List<Integer> result) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int count = 0;
        
        // Merge the two halves and count how many elements are smaller
        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                temp[k++] = indices[i++];
                result.set(indices[i - 1], result.get(indices[i - 1]) + count);
            } else {
                temp[k++] = indices[j++];
                count++;
            }
        }
        
        // Copy remaining elements from the left half
        while (i <= mid) {
            temp[k++] = indices[i++];
            result.set(indices[i - 1], result.get(indices[i - 1]) + count);
        }
        
        // Copy remaining elements from the right half
        while (j <= right) {
            temp[k++] = indices[j++];
        }
        
        // Copy back the sorted indices into the original array
        System.arraycopy(temp, left, indices, left, right - left + 1);
    }
}