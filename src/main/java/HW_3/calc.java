package HW_3;
//Задача1. Напишите программу-калькулятор, которая запрашивает у пользователя два числа и выполняет операцию возведения первого
//        числа в степень второго числа. Если введены некорректные числа или происходит деление на ноль, необходимо обработать
//        соответствующие исключения и вывести информативное сообщение об ошибке.
//        Важно! С использованием принципа одного уровня абстракции!
//        **В этой задаче мы создаем класс PowerCalculator, который содержит метод calculatePower(),
//        выполняющий операцию возведения числа в степень. Если введено некорректное основание (ноль) и отрицательная степень,
//        выбрасывается исключение InvalidInputException.
//
//        В методе main() мы запрашиваем у пользователя основание и показатель степени, вызываем метод calculatePower()
//        и выводим результат. Если введены некорректные числа или происходит ошибка ввода, соответствующие исключения
//        перехватываются и выводится информативное сообщение об ошибке.
//
//        Обратите внимание, что в этой задаче мы использовали собственное исключение InvalidInputException, чтобы явно
//        указать на некорректный ввод. Это помогает разделить обработку ошибок на соответствующие уровни абстракции.**


import java.util.InputMismatchException;
import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        double degreeBasis;
        double degreeIndicator;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                try {
                    System.out.print("Введите основание степени: ");
                    degreeBasis = scanner.nextDouble();
                    calculatePower(degreeBasis, 1);
                    break;
                } catch (InvalidInputException e) {
                    System.out.println("Ошибка: " + e.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex) {
                    System.out.println("Нужно ввести цифры");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Введите показатель степени: ");
                    degreeIndicator = scanner.nextInt();
                    calculatePower(1, degreeIndicator);
                    break;
                } catch (InvalidInputException e) {
                    System.out.println("Ошибка: " + e.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex) {
                    System.out.println("Нужно ввести цифры");
                    scanner.nextLine();
                }
            }
            System.out.printf("Решение: %s ** %s = %s", degreeBasis, degreeIndicator,
                    String.format("%.2f", calculatePower(degreeBasis, degreeIndicator)));
        } catch (Exception ex) {
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        } finally {
            scanner.close();
        }
    }

    public static double calculatePower(double a, double b) throws InvalidInputException {
        if (a == 0) {
            throw new InvalidInputException("введено некорректное основание ");
        }
        if (b < 0) {
            throw new InvalidInputException("введена отрицательная степень ");
        }
        return Math.pow(a, b);
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}