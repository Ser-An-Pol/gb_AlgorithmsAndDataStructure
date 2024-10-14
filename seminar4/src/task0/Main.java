package task0;

public class Main {
    public static void main(String[] args) {
        BinTree tree = new BinTree();

        tree.add(2);
        tree.add(4);
        tree.add(7);
        tree.add(3);
        tree.add(1);

        System.out.println(tree);
        System.out.println(tree.find(14));
    }
}
