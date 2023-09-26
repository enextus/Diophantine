import java.util.Random;
import java.util.Scanner;

public class Tools {
	// Method to generate a random integer from 1 to 100
	public int genInteger() {
		final Random RANDOM = new Random(); // Initialize the random number generator
		int randomInt = RANDOM.nextInt(100) + 1; // Generate a random number
		System.out.println("Random Integer: " + randomInt); // Print the number to the screen
		return randomInt; // Return the generated number
	}

	// Method to get an integer value from the user with zero check
	public int inputValue(String variable, Scanner input) {
		int value; // Declare a variable to store the value
		System.out.print("Enter the value of " + variable + ": "); // Prompt for input

		// Loop to get a non-zero value
		while ((value = input.nextInt()) == 0)
			System.out.println(variable + " cannot be 0. Enter a valid value of " + variable + " again: "); // Error message
		return value; // Return the entered value
	}
}
