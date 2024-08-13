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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        iot(root);

        //swap the swaped nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void iot(TreeNode root){
        if(root == null){
            return;
        }

        iot(root.left);

        if(prev!=null && prev.val>root.val){
            if(first==null){
                first = prev;
            }
            second = root;
        }

        prev = root;
        
        iot(root.right);
    }
}