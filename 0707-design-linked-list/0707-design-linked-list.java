class MyLinkedList {
    class Node{
        int val;
        Node next,prev;

        Node(int val){
            this.val=val;
        }
    }
    Node head=null;
    Node tail=null;
    int size;
    
    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size) return -1;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        
        Node node=new Node(val);
        if(size==0){
            head=tail=node;
        }else{
            node.next=head;
            head.prev=node;
            head=node;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node node=new Node(val);
        if(size==0){
            head=tail=node;
        }else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>size) return;
        
        Node temp=head;
       
        if(index==0){
            addAtHead(val);
            return;
        }else if(index==size){
            addAtTail(val);
            return;
        }
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        
        Node node=new Node(val);
        node.prev=temp.prev;
        node.next=temp;
        temp.prev.next=node;
        temp.prev=node;

        size++;
        
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) return;
        if(size==1) {
            head=tail=null;
        }else if(index==0){
            head=head.next;
            head.prev=null;
        }else if(index==size-1){
            tail=tail.prev;
            tail.next=null;
        }else{
            Node curr=head;
            for(int i=0;i<index;i++){
                curr=curr.next;
            }
            curr.prev.next=curr.next;
            curr.next.prev=curr.prev;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */