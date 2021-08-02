package myLinkedList;

public class MyLinkedList {
    private DNode head;
    private DNode tail;
    private int capacity;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isTail() {
        return tail!=null;}

    public boolean isHead() {
        return head!=null;}

    public boolean isEmpty() {
        return capacity==0;
    }
    public void pushFirst(Object o) {
        DNode n = new DNode(o);
        if (!isHead()){
            head=n;
            tail = n;
            head.prev=tail;
            tail.next=head;
        }
        n.prev = head;
        n.next=tail;
        head.next=n;
        head=n;
        capacity++;
    }
    public void pushLast(Object o) {
        DNode n = new DNode(o);
        if (!isTail()){
            tail=n;
            head = n;
            tail.next=head;
            head.prev=tail;
        }
        n.next=tail;
        n.prev=head;
        tail.prev=n;
        tail=n;
        capacity++;
    }
    public Object popHead() {
        if (isEmpty()) throw new RuntimeException (" List is empty!");
        Object temp = head.object;
        head = head.prev;
        capacity--;
        return temp;
    }
    public Object popTail() {
        if (isEmpty()) throw new RuntimeException (" List is empty!");
        Object temp = tail.object;
        tail = tail.next;
        capacity--;
        return temp;
    }
}
