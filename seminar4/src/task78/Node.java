package task78;

public class Node <T extends Comparable<T>> {
    T value;
    Node<T> parent;
    Node<T> left_child;
    Node<T> right_child;

    public Node(T value) {
        this.value = value;
    }
}
