package set;

import java.util.Random;
import java.util.Scanner;

public class Settings {
    public static int getInt() {
        System.out.println("Введите целое число...");

        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        int result = 0;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Попробуйте снова...");
            }
        } while (!success);
        return result;
    }

    public static int[] getArray(int N) {
        if (N < 1) throw new IllegalArgumentException("Неорректная дина массива!");

        int[] array = new int[N];
        Random rnd = new Random();

        for (int i = 0; i < N; i++) array[i] = rnd.nextInt(1001);

        return array;
    }

    public static long[] getArrayLong(int N) {
        if (N < 1) throw new IllegalArgumentException("Неорректная дина массива!");

        long[] array = new long[N];
        Random rnd = new Random();

        for (int i = 0; i < N; i++) array[i] = rnd.nextLong(1001);

        return array;
    }
}
