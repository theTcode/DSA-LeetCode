class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length-2;i++){
            int a = arr[i];
            int b = arr[i+1];
            int c = arr[i+2];

            if(a%2==1 && b%2==1 && c%2==1){
                return true;
            }
        }
        return false;
    }
}