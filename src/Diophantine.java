import java.util.Scanner;

public class Diophantine {
    public static void main(String[] args) {
        boolean found = false;
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
            for (int y = 0; y <= d / b; y++) {
                for (int z = 0; z <= d / c; z++) {
                    if (a * x + b * y + c * z == d) {
                        System.out.println("Possible solution: x = " + x + ", y = " + y + ", z = " + z);
                        found = true;
                    }
                    System.out.println("z : " + z);
                }
                System.out.println("-> 5.");
            }
            if (!found) System.out.println("No solution found.");
        }
        System.out.println("-> 5.");
    }

}
