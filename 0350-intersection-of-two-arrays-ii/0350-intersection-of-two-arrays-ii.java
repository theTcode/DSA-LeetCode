class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums1.length>nums2.length){
            for(int i = 0; i < nums1.length; i++){
                if(map.containsKey(nums1[i])) {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                } 
                else{
                    map.put(nums1[i], 1);
                }
            }
        }
        else{
            for (int i = 0; i < nums2.length; i++){
                if(map.containsKey(nums2[i])) {
                    map.put(nums2[i], map.get(nums2[i]) + 1);
                } 
                else{
                    map.put(nums2[i], 1);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(nums1.length<=nums2.length){
            for(int i = 0; i < nums1.length; i++){
                if(map.containsKey(nums1[i])) {
                    ans.add(nums1[i]);
                    map.put(nums1[i], map.get(nums1[i]) - 1);
                    if(map.get(nums1[i])==0){
                        map.remove(nums1[i]);
                    }
                }
            }
        }
        else{
            for(int i = 0; i < nums2.length; i++){
                if(map.containsKey(nums2[i])) {
                    ans.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                    if(map.get(nums2[i])==0){
                        map.remove(nums2[i]);
                    }
                }
            }
        }

        int[] res = new int[ans.size()];
        for(int j=0;j<ans.size();j++){
            res[j] = ans.get(j);
        }
        return res;
    }
}