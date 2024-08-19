class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int i=0, j=0, k=0;
        Stack s1 = new Stack<>();
        Stack s2 =  new Stack<>();

        while(s1.size() != nums1.length){
            j=0;
            int num = nums1[i++];
            s1.push(num);

            while(num != nums2[j]){
                s2.push(nums2[j++]);
            }
            s2.push(nums2[j++]);
            while(j!=nums2.length && nums2[j]<num){
                s2.push(nums2[j++]);
            }
            if(j!=nums2.length){
                ans[k++] = nums2[j];
            }
            else{
                ans[k++]=-1;
            }
            while(!s2.isEmpty()){
                s2.pop();
            }
        }
        return ans;
    }
}