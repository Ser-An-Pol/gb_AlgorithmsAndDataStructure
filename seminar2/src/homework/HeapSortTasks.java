package homework;

//todo Задание 1. Сортировка массива задач по приоритету (Heap Sort)
//  Вам дан список задач, каждая из которых имеет приоритет (целое число).
//  Напишите функцию sortTasksByPriority, которая сортирует задачи по
//  убыванию приоритета с использованием сортировки кучей (Heap Sort).

import set.Settings;

import java.util.Arrays;

public class HeapSortTasks {
    public static void heapify(int[] arr, int last, int i) {
        // ваша реализация
        int leftChild = 2 * i + 1;
        int rightChild = leftChild + 1;

        int winner;
        if (rightChild <= last) winner = (arr[leftChild] > arr[rightChild]) ?
                (arr[leftChild] > arr[i]) ? leftChild : i :
                (arr[rightChild] > arr[i]) ? rightChild : i;
        else if (leftChild == last) winner = (arr[leftChild] > arr[i]) ? leftChild : i;
        else winner = i;


        if (winner != i) {
            int temp = arr[winner];
            arr[winner] = arr[i];
            arr[i] = temp;

            heapify(arr, last, winner);
        }
    }

    public static int[] sortTasksByPriority(int[] tasks) {
        // ваша реализация
        int len = tasks.length;
        int[] array = Arrays.copyOf(tasks, len);
        int last = len - 1;

        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(array, last, i);

        do {
            int temp = array[0];
            array[0] = array[last];
            array[last] = temp;
            last--;
            heapify(array, last, 0);
        } while (last > 0);

        return array;
    }

    public static void main(String[] args) {
        //int[] tasks = {3, 1, 4, 2, 5};
        int[] tasks = Settings.getArray(Settings.getInt());
        System.out.println(Arrays.toString(tasks));
        System.out.println(Arrays.toString(sortTasksByPriority(tasks)));
    }
}
