class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length<3){
            return 0;
        }
        int maxLength=0;

        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                int len = find(arr, i);
                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }
    public int find(int[] arr, int peak){
        int left = peak;
        int right = peak;

        while(left>0 && arr[left-1]<arr[left]){
            left--;
        }

        while(right<arr.length-1 && arr[right]>arr[right+1]){
            right++;
        }

        return right-left+1;
    }
}