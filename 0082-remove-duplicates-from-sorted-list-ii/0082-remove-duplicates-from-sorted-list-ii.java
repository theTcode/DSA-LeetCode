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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        int x = Integer.MIN_VALUE;
        
        while(next != null){
            if(curr.val == next.val){
                x = curr.val;
            }
            else{
                if(x != curr.val){
                tail.next = curr;
                tail = tail.next;
                }
            }
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(prev.val != curr.val){
            tail.next = curr;
            tail = tail.next;
        }

        tail.next = null;
        return dummyHead.next;
    }
}