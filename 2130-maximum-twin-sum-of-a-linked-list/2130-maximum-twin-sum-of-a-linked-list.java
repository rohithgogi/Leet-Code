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
    public int pairSum(ListNode head) {
        if(head==null || head.next==null) return 0;
        int max=0;
        List<Integer> list=new ArrayList<>();
        ListNode slow=head;
        ListNode fast=head;
        list.add(slow.val);
        while(fast.next!=null && fast.next.next!=null){
            
            slow=slow.next;
            list.add(slow.val);
            fast=fast.next.next;
        }
        int i=list.size()-1;
        slow=slow.next;
        while(slow!=null){
            max=Math.max((list.get(i)+slow.val),max);
            slow=slow.next;
            i--;
        }
        return max;
    }
}