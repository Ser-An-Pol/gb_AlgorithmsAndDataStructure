package task567;

//todo Задание 5 (тайминг 5 минут)
//  1.Расширяем структуру связного списка до двухсвязного.
//  2.Мы научились работать с односвязным список, теперь можно ближе познакомиться со структурой двухсвязного списка
//      и особенностей его внутреннего строения.
//  3.Стоит напомнить, что двухсвязный список представляет из себя цепочку элементов, которые умеют ссылаться
//      не только на следующий элемент последовательности, но и на предыдущий.
//  4.Вносить корректировки в уже готовые методы на текущий момент не стоит, их модификацией мы займемся позднее

//todo Задание 6 (тайминг 10 минут)
//  1.Обновляем методы согласно новой структуре.
//  2.Появилась дополнительная переменная, которую необходимо отслеживать во всех операциях.
//  3.Так же благодаря ссылке на последний элемент списка операции работы с концом стали проще
//      и их стоит заменить на логику аналогичную работе с началом списка

//todo Задание 7 (тайминг 15 минут)
//  1.Добавляем метод сортировки для связного списка.
//  2.Можно использовать любой алгоритм, что мы использовали на предыдущем семинаре,
//      но с точки зрения работы связного списка лучше ориентироваться на пузырьковую сортировку,
//      т.к. она взаимодействует с соседними элементами, а не только по индексам, как делают все остальные сортировки.

//todo Домашнее задание

//todo Задание 0
//  Необходимо реализовать метод разворота связного списка


public class DoubleLinkedList {
    public class Node{
        int value;
        Node prev;
        Node next;

    }

    private Node head;
    private Node tail;

    public void addFirst(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.prev = null;
        newNode.next = head;

        if (head == null) {
            head = tail = newNode;
        }
        else {
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.prev = tail;
        newNode.next = null;

        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null) return;
        if (head == tail) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteLast() {
        if (head == null) return;
        if (head == tail) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public boolean hasValue(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    private void deleteNode(Node node) {
        if (node == head) deleteFirst();
        else if (node == tail) deleteLast();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void insertNodeBefore(Node node, Node newNode) {
        newNode.next = node;
        if (node == head) {
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else {
            newNode.prev = node.prev;
            node.prev.next = newNode;
            node.prev = newNode;
        }
    }

    private void shiftNodeBefore(Node node, Node newNode) {
        deleteNode(newNode);
        insertNodeBefore(node, newNode);
    }

    public void quickSort() {
        if (head == null) return;
        quickSort(head, tail);
    }

    private void quickSort(Node start, Node finish) {
        if (start == finish) return;
        Node pivot = start;
        Node current = pivot;

        do {
            current = current.next;
            if (current.value <= pivot.value) {
                Node temp = current;
                current = current.prev;
                if (temp == finish) finish = current;
                if (pivot == start) start = temp;
                shiftNodeBefore(pivot, temp);
            }
        } while (current != finish);
        if (start != pivot) quickSort(start, pivot.prev);
        if (finish != pivot) quickSort(pivot.next, finish);
    }

    public void bubbleSort() {
        if (head == tail) return;
        Node last = tail;

        while (last != head) {
            Node current = head;
            while (current != tail) {
                if (current.value > current.next.value) swapValues(current, current.next);
                current = current.next;
            }
            last = last.prev;
        }
    }

    private void swapValues(Node one, Node two) {
        int temp = one.value;
        one.value = two.value;
        two.value = temp;
    }

    public void revert() {
        Node current = head;
        do {
            swapPrevNext(current);
            current = current.prev;
        } while (current != null);
        current = tail;
        tail = head;
        head = current;
    }

    private void swapPrevNext(Node node) {
        Node temp = node.next;
        node.next = node.prev;
        node.prev = temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DoubleLinkedList: ");
        Node currentNode = head;
        while (currentNode != null) {
            stringBuilder.append(currentNode.value).append("; ");
            currentNode = currentNode.next;
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
