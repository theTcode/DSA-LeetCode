class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int element : nums){
            if(even(element)){
                count++;
            }
        }
        return count;
    }
    boolean even(int num){
        int NbOfDigits = digit(num);
        return NbOfDigits%2==0;
    }

    int digit(int num1){
        if(num1<0){
            num1 = num1 * -1;
        }
        return (int)(Math.log10(num1) + 1);
    }

}