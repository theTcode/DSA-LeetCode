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
    public int pathSum(TreeNode root, int targetSum) {
        return countPath(root, targetSum, new ArrayList<>());
    }
    private int countPath(TreeNode root, int sum, List<Integer> path){
        if(root==null){
            return 0;
        }

        path.add(root.val);

        int count=0;
        long pathSum = 0;

        for (int i = path.size()-1; i>=0; i--){
            pathSum += path.get(i);

            if(pathSum == sum){
                count++;
            }
        }

        count += countPath(root.left, sum, path) + countPath(root.right, sum, path);

        //backtrack
        path.remove(path.size()-1);
        return count;
    }
}