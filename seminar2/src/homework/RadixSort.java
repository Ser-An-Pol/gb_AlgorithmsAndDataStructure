package homework;

//todo Задача 2. Сортировка номеров телефонов по разрядам (Radix Sort)
//  Напишите функцию sortPhoneNumbers, которая сортирует номера телефонов
//  в порядке возрастания с использованием поразрядной сортировки (Radix Sort).

import set.Settings;

import java.util.Arrays;

public class RadixSort {
    public static boolean countingSort(long[] arr, long exp) {
        // ваша реализация
        int len = arr.length;
        int[] count = new int[10];
        for (long l : arr) count[getDigit(l, exp)]++;
        if (count[0] == len) return false;
        count[0]--;
        for (int i = 1; i < 10; i++) count[i] += count[i-1];

        long[] sorted = new long[len];
        for (int i = len - 1; i >=0 ; i--) sorted[count[getDigit(arr[i], exp)]--] = arr[i];

        System.arraycopy(sorted, 0, arr, 0, len);
        return true;
    }

    public static long[] sortPhoneNumbers(long[] arr) {
        // ваша реализация
        long exp = 1;
        while (countingSort(arr, exp)) exp *= 10;
        return arr;
    }

    private static int getDigit(long a, long exp) {
        return (int) ((a / exp) % 10);
    }


    public static void main(String[] args) {
//        long[] phoneNumbers = {9876543210L, 1234567890L,
//                5555555555L, 1000000000L};
        long[] phoneNumbers = Settings.getArrayLong(Settings.getInt());
        System.out.println(Arrays.toString(sortPhoneNumbers(phoneNumbers)));
    }
}
