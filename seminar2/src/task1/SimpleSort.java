package task1;

//todo Задание 1 (тайминг 10 минут)
//  1.Необходимо написать один из простых алгоритмов сортировки, имеющий сложность O(n2).
//  2.Можно выбрать из пузырьковой сортировки, сортировки вставками и сортировки выбором.
//  3.Следует обратить внимание на сложность данных алгоритмов и указать признаки квадратичной сложности для каждого из них.

import java.util.Arrays;

import static set.Settings.getArray;
import static set.Settings.getInt;

public class SimpleSort {
    public static void main(String[] args) {

        int[] array = getArray(getInt());

        System.out.println(Arrays.toString(array));
        //bubbleSort(array);
        //directSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void bubbleSort(int[] array) {
        for (int i =  array.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public static void directSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int minPos = i;
            for (int j = i + 1; j < len; j++)
                if (array[minPos] > array[j]) minPos = j;
            if (minPos != i) {
                int temp = array[minPos];
                array[minPos] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void insertSort(int[] array) {
        int len = array.length - 1;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
