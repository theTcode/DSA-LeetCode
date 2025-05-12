class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;

        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<n;k++){
                    if(i==j || j==k || i==k){
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j]*10 + digits[k];
                    if(num>=100 && num%2==0){
                        nums.add(num);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>(nums);
        Collections.sort(ans);
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}