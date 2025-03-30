class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOcc = new int[26];

        for(int i=0;i<s.length();i++){
            lastOcc[s.charAt(i)-'a']=i;
        }

        int start=0, end=0;
        List<Integer> sizes = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            end = Math.max(end, lastOcc[s.charAt(i)-'a']);
            if(i==end){
                sizes.add(i-start+1);
                start=i+1;
            }
        }
        return sizes;
    }
}