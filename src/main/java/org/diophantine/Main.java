package org.diophantine;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tools tm = new Tools();
        List<Integer> wList = Arrays.asList(1, 2, 3);

        for (int rt :
                wList
        ) {
            System.out.println("Try: " + rt);
            System.out.println("RND: " + tm.genInteger() + "\n");
        }

        Scanner input = new Scanner(System.in);
        System.out.print("a*x + b*y + c*z = d\n");

        int a = tm.inputValue("a", input);
        int b = tm.inputValue("b", input);
        int c = tm.inputValue("c", input);

        System.out.print("Enter the value of d: ");
        int d = input.nextInt();

        boolean solved = false;

        for (int x = 0; x <= d / a; x++) {
            for (int y = 0; y <= (d - (a * x)) / b; y++) {
                int z = (d - (a * x) - (b * y)) / c;
                if ((a * x + b * y + c * z) == d) {
                    System.out.println("Solution: x = " + x + ", y = " + y + ", z = " + z);
                    solved = true;
                }
            }
        }

        if (!solved) System.out.println("No solution found.");

    }

}
