class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }
    static void combinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> sa){
        if(target == 0){
            ans.add(new ArrayList<>(sa));
            return;
        }

        for(int i=index; i<arr.length; i++){

            if(i>index && arr[i]==arr[i-1]) continue;
            if (arr[i] > target) break;

            sa.add(sa.size(), arr[i]);
            combinations(i+1,arr,target-arr[i],ans,sa);
            sa.remove(sa.size()-1);
        }
    }
}