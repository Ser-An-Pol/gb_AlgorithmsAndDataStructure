package task0;

import java.util.ArrayList;
import java.util.List;

public class BinTree {
    Node root;

    public boolean add(int value) {
        Node now = new Node(value);
        if (root == null) {
            root = now;
            return true;
        } else return add(root, now);
    }

    private boolean add(Node local, Node now) {
        if (now.value > local.value) {
            if (local.right_child == null) {
                local.right_child = now;
                now.parent = local.right_child;
                return true;
            } else return add(local.right_child, now);
        } else if (now.value < local.value) {
            if (local.left_child == null) {
                local.left_child = now;
                now.parent = local.left_child;
                return true;
            } else return add(local.left_child, now);
        }
        else return false;
    }

//    public boolean add(int value) {
//        Node now = new Node(value);
//        if (root == null) {
//            root = now;
//            return true;
//        } else {
//            Node current = root;
//            while (true) {
//                if (now.value > current.value) {
//                    if (current.right_child == null) {
//                        current.right_child = now;
//                        now.parent = current.right_child;
//                        return true;
//                    } else current = current.right_child;
//                } else if (now.value < current.value) {
//                    if (current.left_child == null) {
//                        current.left_child = now;
//                        now.parent = current.left_child;
//                        return true;
//                    } else current = current.left_child;
//                } else return false;
//            }
//        }
//    }

    public Node find(int value) {
        return find(root, value);
    }

    private Node find(Node local, int value) {
        if (local == null || local.value == value) return local;
        if (local.value < value) return find(local.right_child, value);
        else return find(local.left_child, value);
    }

    @Override
    public String toString() {
        if (root == null) return "Tree is empty";
        StringBuilder stringBuilder = new StringBuilder("Tree:\n");
        List<Node> levelNow = new ArrayList<>();
        levelNow.add(root);
        boolean hasNotNull = true;
        while (hasNotNull) {
            List<Node> levelNext = new ArrayList<>();
            hasNotNull = false;
            for (Node node : levelNow) {
                if (node == null) stringBuilder.append("null; ");
                else {
                    stringBuilder.append(node).append("; ");
                    levelNext.add(node.left_child);
                    levelNext.add(node.right_child);
                    if (node.left_child != null || node.right_child != null) hasNotNull = true;
                }
            }
            stringBuilder.append("\n");
            levelNow = levelNext;
        }
        return stringBuilder.toString();
    }
}
