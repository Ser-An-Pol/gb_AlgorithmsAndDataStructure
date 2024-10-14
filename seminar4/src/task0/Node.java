package task0;

public class Node {
    int value;
    Node parent;
    Node left_child;
    Node right_child;
    Color color;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node {value=" + value + '}';
    }
}
