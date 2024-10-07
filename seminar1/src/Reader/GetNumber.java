package Reader;

import java.util.Scanner;

public class GetNumber {

    public static int getInt() {
        System.out.println("Введите целое число...");

        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        int result = 0;

        while (!success) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                success = true;
            } catch (Exception e) {
                System.out.println("Некорректный ввод. Попробуйте ещё раз...");
            }
        }
        return result;
    }
}
