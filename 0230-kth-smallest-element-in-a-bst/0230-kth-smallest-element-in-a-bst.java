/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new LinkedList<>();
        helper(root, queue, k); 

        int ans =0;
        for(int i=0;i<k;i++){
            ans = queue.poll();
        }
        return ans;
    }
    private void helper(TreeNode node, Queue<Integer> queue, int k){
        if(node == null){
            return;
        }

        helper(node.left, queue, k);
        
        queue.offer(node.val);

        helper(node.right, queue, k);
    }
}