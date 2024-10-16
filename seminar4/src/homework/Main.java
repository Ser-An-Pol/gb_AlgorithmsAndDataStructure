package homework;

//todo Домашнее задание
//  1. Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево.
//      И реализовать в нем метод добавления новых элементов с балансировкой.
//  2. Красно-черное дерево имеет следующие критерии:
//      ● Каждая нода имеет цвет (красный или черный)
//      ● Корень дерева всегда черный
//      ● Новая нода всегда красная
//      ● Красные ноды могут быть только левым ребенком
//      ● У красной ноды все дети черного цвета
//  3. Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести
//      балансировку, благодаря которой все критерии выше станут валидными.
//  4. Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.
//  Критерии применения этих операций следующие:
//      ● Если правый ребенок – красный, а левый - черный, то применяем малый правый поворот
//      ● Если левый ребенок красный и его левый ребенок тоже красный – применяем малый левый поворот
//      ● Если оба ребенка красные – делаем смену цвета
//      ● Если корень стал красным – просто перекрашиваем его в черный

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LRBTree<Integer> tree = new LRBTree<>();
        Random rnd = new Random();
        do {
            int nn = rnd.nextInt(70);
            System.out.println("Add number: " + nn);
            tree.add(nn);
            System.out.println(tree.toString(100));
        } while (getAnswer());
    }

    public static boolean getAnswer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Again?");
        return switch (scanner.nextLine().charAt(0)) {
            case 'y', 'Y', 'д', 'Д' -> Boolean.TRUE;
            default -> Boolean.FALSE;
        };
    }
}
