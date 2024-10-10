package task1234;

//todo Задание 1 (тайминг 5 минут)
//  1.Реализуем простой односвязный список.
//  2.Пишем только структуру, никаких методов не требуется.

//todo Задание 2 (тайминг 10 минут)
//  1.Реализуем метод добавления новых элементов в начало списка и удаление первого элемента связного списка.
//  2.Односвязный список всегда имеет ссылку на первый элемент последовательности, потому именно с реализации
//       методов для первого элемента последовательности стоит начать

//todo Задание 3 (тайминг 10 минут)
//  1.Реализуем метод поиска элемента в односвязном списке для проверки наличия элемента внутри списка.
//  2.Для корректной работы со связным список необходимо понимать, как именно можно обходить все значения
//      внутри связного списка.
//  3.Для нашего примера проще всего будет написать метод поиска значения в связном списке и возвращения
//      из метода информации о наличии искомого внутри списка.

//todo Задание 4 (тайминг 10 минут)
//  1.Реализуем метод добавления новых элементов в конец списка и удаление последнего элемента связного списка.
//  2.Теперь, когда мы понимаем, как можно искать значения внутри связного списка, мы можем сделать методы добавления
//  и удаления элементов в конец нашего односвязного списка.

//todo Домашнее задание

//todo Задание 0
//  Необходимо реализовать метод разворота связного списка

//todo Задание 1. Удаление дубликатов в односвязном списке
//  Напишите метод, который удаляет все дубликаты из односвязного списка

//todo Задача 2. Поиск среднего элемента в односвязном списке
//  Реализуйте метод, который находит средний элемент односвязного списка за
//  один проход по нему.

//todo Задача 3. Слияние двух отсортированных односвязных списков
//  Реализуйте метод, который сливает два отсортированных односвязных списка
//  в один отсортированный список.

public class SingleLinkedList {
    public class Node {
        int value;
        Node next;
    }

    private Node head;

    public void addFirst(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int value) {
        if (head == null) addFirst(value);
        else {
            Node last = head;
            while (last.next != null) last = last.next;

            Node newNode = new Node();
            newNode.value = value;
            newNode.next = null;
            last.next = newNode;
        }
    }

    public void deleteFirst() {
        if (head != null) head = head.next;
    }

    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) head = null;
        else {
            Node last = head;
            while (last.next.next != null) last = last.next;
            last.next = null;
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

    public void revert() {
        if (head == null || head.next == null) return;
        Node last;
        Node newhead = head, current = head;
        boolean isHead = true;
        do {
            last = head;
            while (last.next != null) last = last.next;
            if (isHead) {
                newhead = last;
                isHead = false;
            }
            else current.next = last;
            current = last;
            deleteLast();
        } while (head != null);
        head = newhead;
    }

    public double mean() {
        if (head == null) throw new RuntimeException("В списке нет данных для вычисления среднего значения!");
        Node current = head;
        int count = 0, sum = 0;
        while (current != null) {
            sum += current.value;
            count++;
            current = current.next;
        }
        return sum * 1.0 / count;
    }

    public int findMiddle() {
        if (head == null) throw new RuntimeException("В списке нет данных для поиска среднего элемента!");
        Node current = head;
        Node current2 = head;
        while (current2 != null && current2.next != null) {
            current = current.next;
            current2 = current2.next.next;
        }
        return current.value;
    }

    private void deleteDuplicate(Node node) {
        int refValue = node.value;
        Node current = node;
        while (current.next != null) {
            if (current.next.value == refValue) {
                current.next = current.next.next;
            }
            else current = current.next;
        }
    }

    public void deleteDuplicate() {
        if (head == null) return;
        Node current = head;
        while (current != null && current.next != null) {
            deleteDuplicate(current);
            current = current.next;
        }
    }

    public static SingleLinkedList mergeSortedLists(SingleLinkedList sorted1, SingleLinkedList sorted2) {
        SingleLinkedList result = new SingleLinkedList();
        Node current1 = sorted1.head;
        Node current2 = sorted2.head;

        while (current1 != null && current2 != null) {
            if (current1.value > current2.value) {
                result.addLast(current2.value);
                current2 = current2.next;
            } else {
                result.addLast(current1.value);
                current1 = current1.next;
            }
        }
        current1 = (current1 == null) ? current2 : current1;
        while (current1 != null) {
            result.addLast(current1.value);
            current1 = current1.next;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SingleLinkedList: ");
        Node currentNode = head;
        while (currentNode != null) {
            stringBuilder.append(currentNode.value).append("; ");
            currentNode = currentNode.next;
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
