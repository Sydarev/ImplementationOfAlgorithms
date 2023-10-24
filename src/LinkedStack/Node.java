package LinkedStack;

public class Node {
    private int value;
    private Node prev; // ссылка на обёртку предыдущего элемента

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getPrev() {
        return prev;
    }

    /** Связывание узла с предыдущим */
    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
