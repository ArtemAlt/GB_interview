package myLinkedList;


import java.util.Objects;

class DNode {
    Object object;
    DNode next;
    DNode prev;
    public DNode(Object o) {
        this.object = o;
    }
    @Override
    public String toString() {
        return String.format("Node(c=%s)", object);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DNode node = (DNode) o;
        return Objects.equals(o, node.object) ;
    }

}
