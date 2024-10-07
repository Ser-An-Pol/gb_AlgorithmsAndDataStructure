package task3;

//todo Задание 3 (тайминг 15 минут)
//  1. Необходимо написать алгоритм поиска всех доступных комбинаций
//      (посчитать количество) для количества кубиков K с количеством граней N.
//  2. У вас есть 2 варианта на выбор – количество кубиков может быть строго
//      ограничено (4 кубика, например), либо их количество будет динамическим. Выбор за вами.
//  3. Если вы реализуете простой вариант, обращает внимание, что данное решение имеет сложность O(n^4),
//      но если количество кубиков сделать переменной, то она трансформируется в O(n^k), что будет представлять
//      собой экспоненциальную сложность. Для второго решения очевидно, что его сложность O(n^k) с самого начала.

import java.math.BigInteger;

import static Reader.GetNumber.getInt;

public class Main {
    public static BigInteger count = BigInteger.ZERO;
    public static int countOfFaces;

    public static void main(String[] args) {

        System.out.println("Количество кубиков:");
        int K = getInt();
        System.out.println("Количество граней:");
        countOfFaces = getInt();

        cubic(K);
        System.out.println("Количество возможных комбинаций составляет (если считать, что кубики нетождественны):\n" + count);
    }

    public static void cubic(int number) {
        if (number == 0) {
            count = count.add(BigInteger.ONE);
            return;
        }
        for (int i = 0; i < countOfFaces; i++) cubic(number-1);
    }
}
