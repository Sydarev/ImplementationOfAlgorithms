package LinkedStack;

public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) {
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++;
    }

    public int pop() {
        int ans = tail.getValue();
        tail = tail.getPrev();
        size--;
        return ans;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public String toString() {
        Node current = tail;
        StringBuilder str = new StringBuilder();
        if (isEmpty()) return "EMPTY";
        if (current.getPrev() == null) return str.append(tail.getValue()).toString();
        while (current != null) {
            str.append(current.getValue());
            if (current.getPrev() != null) str.append(" -> ");
            current = current.getPrev();
        }
        return str.toString();
    }
}
