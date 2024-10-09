package task3;

//todo
//  1.Пишем тесты для сравнения производительности сортировки больших массивов.
//  2.Для наглядного результата стоит сравнивать массивы до 100 000 элементов.
//      При таком подходе будет явно видно, какая из сортировок окажется быстрее.

import java.util.Arrays;
import java.util.Date;

import static set.Settings.getArray;
import static set.Settings.getInt;
import static task1.SimpleSort.bubbleSort;
import static task2.QuickSort.quickSort;

public class Mesure {
    public static void main(String[] args) {
        int[] array = getArray(getInt());
        int[] array1 = Arrays.copyOf(array, array.length);

//        System.out.println(Arrays.toString(array));
        long start = (new Date()).getTime();
        bubbleSort(array);
        long delta = (new Date()).getTime() - start;
//        System.out.println(Arrays.toString(array));
        System.out.println("Пузырьковая сортировка длилась " + delta + "ms");

//        System.out.println(Arrays.toString(array1));
        start = (new Date()).getTime();
        quickSort(array1);
        delta = (new Date()).getTime() - start;
//        System.out.println(Arrays.toString(array1));
        System.out.println("Быстрая сортировка длилась " + delta + "ms");
    }
}
