package HW_2;

//Задача 1
//Напишите программу, которая запрашивает у пользователя число и проверяет,
//является ли оно положительным. Если число отрицательное или равно нулю,
//программа должна выбрасывать исключение InvalidNumberException с сообщением "Некорректное число".
//В противном случае, программа должна выводить сообщение "Число корректно".

import java.util.Scanner;

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}
public class positive {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int value;
            while (true) {
                try {
                    System.out.print("Введите целое положительное число: ");
                    value = scanner.nextInt();
                    checkInput(value);
                    break;
                } catch (InvalidNumberException ex) {
                    System.out.println("Некорректное число");
                    scanner.nextLine();
                }
            }
        }
    }
    public static void checkInput(int value) throws InvalidNumberException {
        if (value <= 0) {
            throw new InvalidNumberException("Некорректное число");
        }
        System.out.println("Число корректно.");
    }
}
