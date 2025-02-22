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
    private String s;
    private int ind, level;

    public TreeNode recoverFromPreorder(String traversal) {
        this.s = traversal;
        this.ind = 0;
        this.level = 0;
        TreeNode node = new TreeNode(-1);
        this.helper(node,0);
        return node.left;    
    }

    private void helper(TreeNode parent, int depth){
        while(this.ind < this.s.length() && depth==level){
            int num=0;
            while(this.ind < this.s.length() && Character.isDigit(this.s.charAt(this.ind))){
                num = num*10 + (this.s.charAt(this.ind++)-'0');
            }

            TreeNode node = new TreeNode(num);
            if(parent.left==null){
                parent.left = node;
            }
            else{
                parent.right = node;
            }

            this.level = 0;
            while(this.ind < this.s.length() && this.s.charAt(this.ind)=='-'){
                this.level++;
                this.ind++;
            }
            this.helper(node, depth+1);
        }
    }
}