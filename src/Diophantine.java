import java.util.Scanner;

public class Diophantine {
    public static void main(String[] args) {
        boolean solutionFound = false;
        Scanner input = new Scanner(System.in);
        System.out.print("a*x + b*y + c*z = d\n");
        System.out.print("Enter the values of a: ");
        int a = input.nextInt();
        System.out.print("Enter the values of b: ");
        int b = input.nextInt();
        System.out.print("Enter the values of c: ");
        int c = input.nextInt();
        System.out.print("Enter the value of d: ");
        int d = input.nextInt();

        for (int x = 0; x <= d / a; x++) {
            for (int y = 0; y <= (d - (a * x)) / b; y++) {
                int z = (d - (a * x) - (b * y)) / c;
                if ((a * x + b * y + c * z) == d)
                    System.out.println("One solution: x = " + x + ", y = " + y + ", z = " + z);
                solutionFound = true;
            }
        }

        if (!solutionFound) System.out.println("No solution found.");
    }

}