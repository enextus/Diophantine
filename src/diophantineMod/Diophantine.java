package diophantineMod;

import java.util.ArrayList;
import java.util.List;
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

        List<int[]> solved = findSolution(a, b, c, d);

        if (solved.isEmpty()) System.out.println("No solution found.");

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

    public static List<int[]> findSolution(int a, int b, int c, int d) {
        List<int[]> solutions = new ArrayList<>();

        for (int x = 0; x <= d / a; x++) {
            for (int y = 0; y <= (d - a * x) / b; y++) {
                int z = (d - a * x - b * y) / c;
                if (a * x + b * y + c * z == d) {
                    solutions.add(new int[]{x, y, z});
                }
            }
        }

        for (int[] solution : solutions) {
            System.out.printf("Solution: x = %d, y = %d, z = %d%n", solution[0], solution[1], solution[2]);
        }

        return solutions;
    }

}
