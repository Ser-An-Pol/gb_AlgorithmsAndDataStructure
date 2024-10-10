import task1234.SingleLinkedList;
import task567.DoubleLinkedList;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        //DoubleLinkedList linkedList = new DoubleLinkedList();
        Random random = new Random();

        for (int i = 0; i < 7; i++) linkedList.addFirst(random.nextInt(10));
        System.out.println(linkedList);

//        linkedList.deleteFirst();
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.hasValue(25));
//
//        linkedList.deleteLast();
//        System.out.println(linkedList);
//
//        linkedList.addLast(111);
//        System.out.println(linkedList);


//        long start = (new Date()).getTime();
//        linkedList.quickSort();
////        linkedList.bubbleSort();
//        long delta = (new Date()).getTime() - start;
////        System.out.println(linkedList);
//        System.out.println("Time = " + delta + "ms");

//        linkedList.revert();
//        linkedList.deleteDuplicate();
//        System.out.println(linkedList);

        System.out.println("Середина списка = " + linkedList.findMiddle());

        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();

        int last = 7;
        for (int i = 0; i < last; i++)
            list1.addFirst((last-i)*10 + random.nextInt(10));
        for (int i = 0; i < last; i++)
            list2.addFirst((last-i)*10 + random.nextInt(10));
        System.out.println("1: " + list1);
        System.out.println("2: " + list2);
        SingleLinkedList list = SingleLinkedList.mergeSortedLists(list1, list2);
        System.out.println(list);
    }
}