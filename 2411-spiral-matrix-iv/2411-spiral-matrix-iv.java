/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode node = head;
        int[][] matrix = new int[m][n];

        int top=0,left=0;
        int bottom=m-1, right=n-1;

        while(top<=bottom && left<=right){
            //top
            for(int i=left;i<=right;i++){
                if(node != null){
                    matrix[top][i] = node.val;
                    node = node.next;
                }
                else{
                    matrix[top][i] = -1;
                }
            }
            top++;

            //right
            for(int i=top;i<=bottom;i++){
                if(node != null){
                    matrix[i][right] = node.val;
                    node = node.next;
                }
                else{
                    matrix[i][right] = -1;
                }
                
            }
            right--;

            //bottom
            if(bottom>top){
                for(int i=right;i>=left;i--){
                    if(node != null){
                        matrix[bottom][i] = node.val;
                        node = node.next;
                    }
                    else{
                        matrix[bottom][i] = -1;
                    }
                }
                bottom--;
            }
            

            //left
            if(right>left){
                for(int i=bottom;i>=top;i--){
                    if(node != null){
                        matrix[i][left] = node.val;
                        node = node.next;
                    }
                    else{
                        matrix[i][left] = -1;
                    }
                }
                left++;
            }
        }
        
        return matrix;
    }
}