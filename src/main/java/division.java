//Простая задача 1: Проверка деления на ноль
//Напишите программу, которая запрашивает у пользователя два целых числа и выполняет их деление.
//Если второе число равно нулю, выбросите исключение ArithmeticException с сообщением "Деление на ноль недопустимо".
//Иначе выведите результат деления на экран.
import java.util.InputMismatchException;
import java.util.Scanner;
public class division {
    public static void main(String[] args) {
        Scanner aScanner = new Scanner(System.in);
        try {
            System.out.println("Введите первое целое число: ");
            int divisible = aScanner.nextInt();
            System.out.println("Введите второе целое число: ");
            int divider = aScanner.nextInt();
            System.out.printf("Решение: %s / %s = %s", divisible, divider, divisible / divider);
        } catch (InputMismatchException a) {
            System.out.println("Введите, целое число.");
        } catch (ArithmeticException b) {
            System.out.println("Деление на ноль недопустимо");
        }
        aScanner.close();
    }
}
