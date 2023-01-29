package DiophantineMod;

import java.util.Random;
import java.util.Scanner;

public class Tools {
    public int genInteger() {
        final Random RANDOM = new Random();
        int randomInt = RANDOM.nextInt(100) + 1;
        System.out.println("Random Integer: " + randomInt);
        return randomInt;
    }

    public int inputValue(String variable, Scanner input) {
        int value;
        System.out.print("Enter the values of " + variable + ": ");

        while ((value = input.nextInt()) == 0) {
            System.out.println(variable + " cannot be 0. Enter the values of " + variable + " again: ");
        }

        return value;
    }

}
