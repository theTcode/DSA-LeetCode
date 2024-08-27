class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    static void combinations(int index, int[] arr, int sum, List<List<Integer>> res, List<Integer> ans){
        if(sum==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i=index; i<arr.length; i++){
            if (arr[i] > sum) break;

            ans.add(ans.size(), arr[i]);
            combinations(i,arr,sum-arr[i],res,ans);
            ans.remove(ans.size()-1);
        }
    }
}