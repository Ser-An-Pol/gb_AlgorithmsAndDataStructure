package task1;


//todo Задание 1 (тайминг 5 минут)
//  Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N. Согласно свойствам линейной сложности,
//  количество итераций цикла будет линейно изменяться относительно изменения размера N

import Reader.GetNumber;

public class Main {
    public static void main(String[] args) {
        int N = GetNumber.getInt();
        System.out.printf("Сумма чисел от 1 до %d равна %d\n", N, addToN(N));
    }

    public static int addToN(int N) {
        if (N < 1) return -1;
        int result = 0;
        for (int i = 1; i <= N; i++) result += i;
        return result;
    }

}
