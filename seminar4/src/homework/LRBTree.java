package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LRBTree<T extends Comparable<T>> {
    Node<T> root;
    private boolean needToBalance;
    private int passCount;

    public LRBTree() {
        needToBalance = false;
    }

    public boolean add(T value) {
        Node<T> now = new Node<>(value);
        now.color = false;
        if (root == null) {
            root = now;
            root.color = true;
            return true;
        }
        boolean success = add(root, now);
        if (needToBalance) balancing(root);
        root.color = true;
        return success;
    }

    private boolean add(Node<T> node, Node<T> now) {
        boolean success = false;
        int compare = node.value.compareTo(now.value);
        if (compare < 0) {
            if (node.right_child == null) {
                node.right_child = now;
                now.parent = node;
                success = true;
                needToBalance = true;
                passCount = 0;
            }
            else success = add(node.right_child, now);
        }
        else if (compare > 0) {
            if (node.left_child == null) {
                node.left_child = now;
                now.parent = node;
                success = true;
                needToBalance = true;
                passCount = 0;
            }
            else success = add(node.left_child, now);
        }
        if (needToBalance) balancing(node);
        return success;
    }

    private void balancing(Node<T> node) {
        if (isBlack(node.left_child) && isRed(node.right_child)) turn_right(node);
        else if (isRed(node.left_child) && isRed(node.left_child.left_child)) turn_left(node);
        else if (isRed(node.left_child) && isRed(node.right_child)) change_colors(node);
        else {
            passCount++;
            if (passCount > 1) {
                needToBalance = false;
                passCount = 0;
            }
        }
    }

    private void change_colors(Node<T> node) {
        node.color = !node.color;
        node.right_child.color = true;
        node.left_child.color = true;
    }

    private void turn_right(Node<T> node) {
        Node<T> newN = node.right_child;
        newN.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.right_child == node) node.parent.right_child = newN;
            else node.parent.left_child = newN;
        }
        else root = newN;

        node.right_child = newN.left_child;
        if (node.right_child != null) node.right_child.parent = node;

        newN.left_child = node;
        newN.left_child.parent = newN;

        newN.color = node.color;
        node.color = false;
    }

    private void turn_left(Node<T> node) {
        Node<T> newN = node.left_child;
        newN.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.right_child == node) node.parent.right_child = newN;
            else node.parent.left_child = newN;
        }
        else root = newN;

        node.left_child = newN.right_child;
        if (node.left_child != null) node.left_child.parent = node;

        newN.right_child = node;
        newN.right_child.parent = newN;

        newN.color = false;
        newN.right_child.color = true;
        newN.left_child.color = true;

    }

    private boolean isBlack(Node<T> node) {
        return node == null || node.color;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) return false;
        return !node.color;
    }

    public String toString(int width) {
        if (root == null) return "Tree is empty";
        StringBuilder stringBuilder = new StringBuilder("LRBTree:\n");
        int nodeWidth = 6;
        String gap = String.join("", Collections.nCopies(width - nodeWidth/2, " "));
        String line = String.join("", Collections.nCopies(2*width, "*")) + "\n";
        String semiline = "     " + String.join("", Collections.nCopies(2*width - 10, "-")) + "     \n";
        String nul = " null ";
        int level = 0;
        int dist;
        stringBuilder.append(line);

        List<Node<T>> now = new ArrayList<>();
        now.add(root);
        stringBuilder.append(gap).append(root).append("\n").append(semiline);
        while (!now.isEmpty()) {
            level++;
            dist = (int) (2.*width/(Math.pow(2, level)+1));
            if (dist <= nodeWidth) return "I can't output this tree with width = " + width + "!\n";
            StringBuilder stringBuilder1 = new StringBuilder();
            List<Node<T>> next = new ArrayList<>();
            for (Node<T> tNode : now) {
                gap = String.join("", Collections.nCopies(dist-nodeWidth, " "));
                stringBuilder1.append(gap);
                if (tNode.left_child == null) stringBuilder1.append(nul);
                else {
                    stringBuilder1.append(tNode.left_child);
                    next.add(tNode.left_child);
                }
                stringBuilder1.append(gap);
                if (tNode.right_child == null) stringBuilder1.append(nul);
                else {
                    stringBuilder1.append(tNode.right_child);
                    next.add(tNode.right_child);
                }
            }
            if (!next.isEmpty()) stringBuilder.append(stringBuilder1).append("\n").append(semiline);
            now = next;
        }
        stringBuilder.append(line).append("\n");
        return stringBuilder.toString();
    }
}
