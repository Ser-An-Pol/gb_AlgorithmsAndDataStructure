package task4;

//todo Задание 4 (тайминг 15 минут)
//  1.После успешной сортировки массива на нем можно использовать бинарный поиск.
//      Необходимо реализовать алгоритм бинарного поиска по элементам.
//  2.Стоит акцентировать внимание, что т.к. алгоритм использует подход
//      «разделяй и властвуй», его удобно писать с помощью рекурсии.
//  3.Так что стоит акцентировать внимание на алгоритмическую сложность данного алгоритма,
//      что его выполнение многократно быстрее простого перебора на больших массивах

import set.Settings;
import task2.QuickSort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = Settings.getArray(Settings.getInt());

        //System.out.println(Arrays.toString(array));
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Введите значение для поиска в массиве...");
        int val = Settings.getInt();
        int ind = binSearch(array, val);
        if (ind == -1) System.out.println("Искомое значение не содержится в массиве");
        else System.out.println("Индекс искомого значения в массиве равен " + ind);

    }

    public static int binSearch(int[] array, int val) {
        return binSearch(array, val, 0, array.length - 1);
    }

    private static int binSearch(int[] array, int val, int start, int finish) {
        int median = (start + finish) / 2;
        if (finish - start == 1) {
            if (array[start] == val) return start;
            if (array[finish] == val) return finish;
            return -1;
        }
        if (array[median] == val) return median;
        else if (array[median] > val)
            return binSearch(array, val, start, median);
        else
            return binSearch(array, val, median, finish);
    }
}
