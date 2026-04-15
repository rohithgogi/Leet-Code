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
    public boolean isPalindrome(ListNode head) {
        // if(head==null ||head.next==null) return true;
        // Stack<Integer> stack=new Stack<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     stack.push(temp.val);
        //     temp=temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        //     if(temp.val!=stack.pop()) return false;
        //     temp=temp.next;
        // }
        // return true;

        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode newNode=reverse(slow.next);
        ListNode first=head;
        ListNode sec=newNode;
        while(sec!=null){
            if(first.val!=sec.val){
                reverse(newNode);
                return false;
            }
            first=first.next;
            sec=sec.next;
        }
        reverse(newNode);
        return true;
    }
    public ListNode reverse(ListNode node){
        if(node==null || node.next==null) return node;
        ListNode prev=null;
        ListNode curr=node;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}