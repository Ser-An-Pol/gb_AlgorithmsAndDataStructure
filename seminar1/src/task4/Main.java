package task4;

//todo Задание 4 (тайминг 10 минут)
//  1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
//  2. Считаем, что 1 и 2 значения последовательности равны 1.
//  3. Искать будем по формуле On=On-1+On-2 что предполагает использовать рекурсивного алгоритма.
//                           n
//                          / \
//                        n-1 n-2 -------- 2^1 операций
//                        / \ / \
//                    n-2 n-3 n-3 n-4 -------- 2^2 операций
//                   / \
//                 n-3 n-4 -------- 2^3 операций
//            ........ ........
//               n-n-1 n-n-2 -------- 2^(n-1) операций


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Reader.GetNumber.getInt;

public class Main {
    public static List<BigInteger> fib;
    public static void main(String[] args) {

        int N = getInt();
        fib = new ArrayList<>(N);
        fib.add(BigInteger.ONE);
        fib.add(BigInteger.ONE);

        long now = (new Date()).getTime();
        System.out.printf("%d-ое число Фибоначи равно %d\n", N, Fib(N-1));
        long delta = (new Date()).getTime() - now;
        System.out.println("It takes " + delta +"ms");
        now = (new Date()).getTime();
        System.out.printf("%d-ое число Фибоначи равно %d\n", N, Fibonachi(N));
        delta = (new Date()).getTime() - now;
        System.out.println("It takes " + delta +"ms");
    }

    public static BigInteger Fibonachi(int n) {
        if (n == 1 || n == 2) return BigInteger.ONE;
        return Fibonachi(n-1).add(Fibonachi(n-2));
    }

    public static BigInteger Fib(int n) {
        int last = n - 1;
        for (int i = fib.size()-2; i < last; i++) fib.add(fib.get(i).add(fib.get(i+1)));
        return fib.get(n);
    }
}
