package homework;

//todo Задача 3. Подсчёт количества букв в строке (Counting Sort)
//  Напишите функцию countLetters, которая подсчитывает количество каждой
//  буквы в строке и выводит их по порядку алфавита. Функция должна игнорировать регистр букв.

import java.util.Map;
import java.util.TreeMap;

public class CountingSortLetters {
    public static void countLetters(String text) {
        // ваша реализация
        Map<Character, Integer> count = new TreeMap<>();
        String str = text.toLowerCase();
        for (char c : str.toCharArray())
            if (Character.isLetter(c)) count.merge(c, 1, Integer::sum);

        System.out.println(count);

    }
    public static void main(String[] args) {
        //String text = "Hello World";
        String text = """
                        The compute() method differs from the merge() method in that the compute()\s
                        method has no effect on missing keys and does not throw an exception""";
        System.out.println("Строка: ");
        System.out.println(text);
        countLetters(text);
        //System.out.println((int)'a');
    }
}
