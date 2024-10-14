package task78;


public class BinTree <T extends Comparable<T>> {
    Node<T> root;

    public boolean add(T value) {
        Node<T> now = new Node<>(value);
        if (root == null) {
            root = now;
            return true;
        }
        return add(root, now);
    }

    private boolean add(Node<T> node, Node<T> now) {
        int compare = node.value.compareTo(now.value);
        if (compare < 0) {
            if (node.right_child == null) {
                node.right_child = now;
                now.parent = node.right_child;
                return true;
            }
            else return add(node.right_child, now);
        }
        else if (compare > 0) {
            if (node.left_child == null) {
                node.left_child = now;
                now.parent = node.left_child;
                return true;
            }
            else return add(node.left_child, now);
        }
        else return false;
    }

    public boolean find(T value) {
        if (root == null) return false;
        else return find(root, value);
    }

    private boolean find(Node<T> node, T value) {
        int compare = node.value.compareTo(value);
        if (compare < 0) {
            if (node.right_child == null) return false;
            else return find(node.right_child, value);
        }
        else if (compare > 0) {
            if (node.left_child == null) return false;
            else return find(node.left_child, value);
        }
        else return true;
    }
}
