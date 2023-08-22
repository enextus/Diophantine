import java.util.Random;
import java.util.Scanner;

public class Tools {
    // Метод для генерации случайного целого числа от 1 до 100
    public int genInteger() {
        final Random RANDOM = new Random(); // Инициализация генератора случайных чисел
        int randomInt = RANDOM.nextInt(100) + 1; // Генерация случайного числа
        System.out.println("Random Integer: " + randomInt); // Вывод числа на экран
        return randomInt; // Возврат сгенерированного числа
    }

    // Метод для получения целочисленного значения от пользователя с проверкой на ноль
    public int inputValue(String variable, Scanner input) {
        int value; // Объявление переменной для хранения значения
        System.out.print("Enter the values of " + variable + ": "); // Приглашение к вводу

        // Цикл для получения ненулевого значения
        while ((value = input.nextInt()) == 0)
            System.out.println(variable + " cannot be 0. Enter the valid values of " + variable + " again: "); // Сообщение об ошибке
        return value; // Возврат введенного значения
    }
}
