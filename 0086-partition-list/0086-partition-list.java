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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode smallhead = small;
        ListNode bigHead = big;

        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }
            else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }

        big.next = null;
        small.next = bigHead.next;
        return smallhead.next;
    }
}