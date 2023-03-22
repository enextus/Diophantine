package diophantineMod;

import java.util.Random;
import java.util.Scanner;

public class Diophantine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("a*x + b*y + c*z = d\n");

        int a = inputValue("a", input);
        int b = inputValue("b", input);
        int c = inputValue("c", input);

        System.out.print("Enter the value of d: ");
        int d = input.nextInt();

        boolean solved = false;

        for (int x = 0; x <= d / a; x++) {
            for (int y = 0; y <= (d - a * x) / b; y++) {
                int z = (d - a * x - b * y) / c;
                if (a * x + b * y + c * z == d) {
                    System.out.printf("Solution: x = %d, y = %d, z = %d%n", x, y, z);
                    solved = true;
                }
            }
        }

        if (!solved) System.out.println("No solution found.");
        input.close();
    }

    private static int inputValue(String var, Scanner input) {
        int value;
        System.out.printf("Enter the value of %s: ", var);
        while ((value = input.nextInt()) == 0) {
            System.out.printf("%s cannot be 0. Enter a valid value for %s: ", var, var);
        }
        return value;
    }

    public static int genInteger() {
        final Random RANDOM = new Random();
        int randomInt = RANDOM.nextInt(100) + 1;
        System.out.println("Random Integer: " + randomInt);
        return randomInt;
    }
}
