package task2;

//todo Задание 2 (тайминг 10 минут)
//  Написать алгоритм поиска простых чисел (делятся только на себя и на 1) в диапазоне от 1 до N. В алгоритме будет
//  использоваться вложенный for, что явно говорит о квадратичной сложности, на этом стоит акцентировать внимание

import Reader.GetNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int counter = 0;
    public static List<Integer> simpleNumbers;
    public static void main(String[] args) {
        simpleNumbers = new ArrayList<>();
        simpleNumbers.add(2);

        int N = GetNumber.getInt();


        System.out.printf("Все простые числа от 1 до %d:\n", N);
//        System.out.println(getSimpleNumbers(N));
        fillSimpleNumbers(N);
        System.out.println(simpleNumbers);
        System.out.printf("Число операций: %d", counter);

    }

    public static void fillSimpleNumbers(int N) {
        if (N < 3) return;
        for (int i = 3; i < N; i++) {
            if (!hasDividers(i)) simpleNumbers.add(i);
        }
    }

    public static boolean hasDividers(int m) {
        for (Integer n : simpleNumbers) {
            if (m % n == 0) return true;
            counter++;
        }
        return false;
    }


//    public static List<Integer> getSimpleNumbers(int N) {
//        List<Integer> result = new ArrayList<>();
//        result.add(1);
//        result.add(2);
//        for (int i = 3; i <= N; i++) {
//            if (!areThereDividers(i)) result.add(i);
//        }
//        return result;
//    }
//
//    public static boolean areThereDividers(int m) {
//        int limit = m;
//        for (int i = 2; i < limit; i++) {
//            counter++;
//            if (m % i == 0) return true;
//            limit = m/i;
//        }
//        return false;
//    }


}
