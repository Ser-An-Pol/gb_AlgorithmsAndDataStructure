package task123456;

public class SingleLinkedList<K, V> {
    Node<K, V> root;

    public boolean push(K key, V value) {
        if (hasKey(key)) return false;
        Node<K, V> node = new Node<>(key, value);
        if (root != null) node.next = root;
        root = node;
        return true;
    }

    public boolean hasKey(K key) {
        Node<K, V> current = root;
        while (current != null) {
            if (current.key.equals(key)) return true;
            current = current.next;
        }
        return false;
    }

    public Node<K, V> pop() {
        Node<K, V> result = root;
        if (result != null) root = root.next;
        return result;
    }

    public V getValue(K key) {
        Node<K, V> current = root;
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public long deleteByValue(V value) {
        if (root == null) return 0;
        long count = 0;
        Node<K, V> node = root;
        Node<K, V> child = root.next;
        while (child != null) {
            if (child.value.equals(value)) {
                node.next = child.next;
                count++;
            }
            else {
                node = child;
                child = node.next;
            }
        }
        if (root.value.equals(value)) {
            root = root.next;
            count++;
        }
        return count;
    }

    public boolean deleteByKey(K key) {
        if (root == null) return false;
        Node<K, V> current = root;
        Node<K, V> child = root.next;
        while (child != null) {
            if (child.key.equals(key)) {
                current.next = child.next;
                return true;
            }
            current = current.next;
            child = current.next;
        }
        if (root.key.equals(key)) {
            root = root.next;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        if (root == null) return "null";
        StringBuilder stringBuilder = new StringBuilder();
        Node<K, V> node = root;
        while (node != null) {
            String str = "(" + node.key + ", " + node.value + "); ";
            stringBuilder.append(str);
            node = node.next;
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
