class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i][0])){
                map.put(nums1[i][0], map.getOrDefault(nums1[i][0],0)+nums1[i][1]);
            }
            else{
                map.put(nums1[i][0], nums1[i][1]);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i][0])){
                map.put(nums2[i][0], map.getOrDefault(nums2[i][0],0)+nums2[i][1]);
            }
            else{
                map.put(nums2[i][0], nums2[i][1]);
            }
        }

        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[][] resArray = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            resArray[i] = list.get(i);
        }
        return resArray;
    }
}