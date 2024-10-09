package task2;

import java.util.Arrays;

import static set.Settings.getArray;
import static set.Settings.getInt;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = getArray(getInt());
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] array, int start, int finish) {
        if (start >= finish) return;
        int pivot = array[(start + finish)/2];
        int left = start;
        int right = finish;
        do {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            if (left <= right) {
                left++;
                right--;
            }
        } while (left < right);
        quickSort(array, start, right);
        quickSort(array, left, finish);
    }
}
