package HW_2;
//Задача 2:
//Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
//Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException
//с сообщением "Деление на ноль недопустимо". В противном случае, программа должна выводить результат деления.
import java.util.InputMismatchException;
import java.util.Scanner;
public class division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            double divisible;
            double divider;
            while (true) {
                try {
                    System.out.print("Введите первое число: ");
                    divisible = scanner.nextDouble();
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Введите цифры");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Введите второе число: ");
                    divider = scanner.nextInt();
                    checkInput(divider);
                    break;
                } catch (DivisionByZeroException ex) {
                    System.out.println("Деление на ноль недопустимо");
                    scanner.nextLine();
                } catch (InputMismatchException ex){
                    System.out.println("Введите цифры");
                    scanner.nextLine();
                }
            }
            System.out.printf("Решение: %s / %s = %s", divisible, divider, String.format("%.2f", divisible / divider));
        } catch (Exception ex) {
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        }
    }
    public static void checkInput(double value) throws DivisionByZeroException {
        if (value == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
    }
}
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}