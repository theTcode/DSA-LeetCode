/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = length(headA);
        int length2 = length(headB);

        int length = Math.min(length1, length2);

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if(length1 != length){
            for(int i=0;i<length1-length;i++){
                nodeA = nodeA.next;
            }
        }
        else{
            for(int i=0;i<length2-length;i++){
                nodeB = nodeB.next;
            }
        }

        while(nodeA != null && nodeB != null){
            if(nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
    int length(ListNode node){
        int length =0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }

}