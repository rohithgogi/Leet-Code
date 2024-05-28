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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;

        for(int i=0;curr!=null && i<left-1;i++){
            prev=curr;
            curr=curr.next;
        }
        ListNode stop=prev;
        ListNode start=curr;

        for(int i=0;i<right-left+1 && curr!=null;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        if(stop!=null){
            stop.next=prev;
        }else{
            head=prev;
        }
        start.next=curr;
        return head;
    }
}