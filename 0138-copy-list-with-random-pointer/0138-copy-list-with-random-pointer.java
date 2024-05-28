/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node curr=head;
        
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }
        curr=head;
        while(curr!=null){//copy random pointers
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        //seperatimg the two lists
        curr=head;
        Node newHead=head.next;
        Node newcurr=newHead;
        while(curr!=null){
            curr.next=newcurr.next;
            curr=curr.next;
            if(curr!=null){
                newcurr.next=curr.next;
                newcurr=newcurr.next;
            }
        }
        return newHead;

    }
}