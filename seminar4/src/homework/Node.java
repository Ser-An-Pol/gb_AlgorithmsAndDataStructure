package homework;

public class Node <T extends Comparable<T>> {
    T value;
    boolean color; //true - black, false - red
    Node<T> parent;
    Node<T> left_child;
    Node<T> right_child;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " (" + ((color) ? "B" : "R") + ")";
    }
}