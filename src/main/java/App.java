import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("a*x + b*y + c*z = d\n");

		int a = inputValue("a", input);
		int b = inputValue("b", input);
		int c = inputValue("c", input);

		System.out.print("Enter the value of d: ");
		int d = input.nextInt();

		List<int[]> solved = DiophantineSolver.findSolution(a, b, c, d);

		if (solved.isEmpty()) System.out.println("No solution found.");

		for (int[] solution : solved) {
			System.out.printf("x = %d, y = %d, z = %d%n", solution[0], solution[1], solution[2]);
		}

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

}
