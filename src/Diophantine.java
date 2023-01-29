import java.util.Scanner;

public class Diophantine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("a*x + b*y + c*z = d\n");

        System.out.print("Enter the values of a: ");
        int a;
        while ((a = input.nextInt()) == 0) {
            System.out.println("a cannot be 0. Enter the values of a again: ");
        }

        System.out.print("Enter the values of b: ");
        int b;
        while ((b = input.nextInt()) == 0) {
            System.out.println("b cannot be 0. Enter the values of b again: ");
        }

        System.out.print("Enter the values of c: ");
        int c;
        while ((c = input.nextInt()) == 0) {
            System.out.println("c cannot be 0. Enter the values of c again: ");
        }

        System.out.print("Enter the value of d: ");
        int d = input.nextInt();

        boolean solved = false;

        for (int x = 0; x <= d / a; x++) {
            for (int y = 0; y <= (d - (a * x)) / b; y++) {
                int z = (d - (a * x) - (b * y)) / c;
                if ((a * x + b * y + c * z) == d) {
                    System.out.println("One solution: x = " + x + ", y = " + y + ", z = " + z);
                    solved = true;
                }
            }
        }

        if (!solved) System.out.println("No solution found.");
    }

}
