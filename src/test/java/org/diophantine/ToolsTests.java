package org.diophantine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class ToolsTests {

	@DisplayName("Test testException")
	@Test
	public void testException() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			int i = 1 / 0;
		});

		String expectedMessage = "/ by zero";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@DisplayName("Test testGenInteger")
	@Test
	public void testGenInteger() {

		final Random RANDOM = new Random();
		int result = RANDOM.nextInt(100) + 1;

		assertTrue(result >= 1 && result <= 100);
	}

	@DisplayName("Test testInputValue_5_5")
	@Test
	public void testInputValue_5_5() {
		Tools tm = new Tools();
		String inputString = "5\n";
		InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
		Scanner input = new Scanner(inputStream);
		int result = tm.inputValue("variable", input);

		assertEquals(5, result);
	}

	@DisplayName("Test testInputValue_100_100")
	@Test
	public void testInputValue_100_100() {
		Tools tm = new Tools();
		String inputString = "100\n";
		InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
		Scanner input = new Scanner(inputStream);
		int result = tm.inputValue("variable", input);

		assertEquals(100, result);
	}

}
