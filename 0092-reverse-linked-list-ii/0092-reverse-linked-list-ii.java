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
        if(head==null || head.next==null) return head;
        Stack<Integer> stack=new Stack<>();
        int cnt=0;
        ListNode temp=head;
        while(temp!=null){
            cnt++;
            if(cnt>=left && cnt<=right){
                stack.push(temp.val);
            }else if(cnt>right){
                break;
            }
            temp=temp.next;
        }
        cnt=0;
        temp=head;
        while(temp!=null){
            cnt++;
            if(cnt>=left && cnt<=right){
                temp.val=stack.pop();
            }
            temp=temp.next;
        }
        return head;
    }
}