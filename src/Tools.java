import java.util.Random;

public class Tools {
	public static int genInteger() {
		final Random RANDOM = new Random();
		int randomInt = RANDOM.nextInt(100) + 1;
		System.out.println("Random Integer: " + randomInt);
		return randomInt;
	}

}
