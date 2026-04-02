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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int size=length(head);
        if(n==size) return head.next;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            if(count==size-n){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return head;
    }
    public static int length(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}