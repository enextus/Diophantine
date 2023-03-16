package diophantineMod;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.testng.Assert.*;

public class ToolsTest {

    private static final String INPUT_5 = "5\n";
    private static final String INPUT_100 = "100\n";

    @Test
    public void testException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 0;
        });

        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGenInteger() {

        final Random RANDOM = new Random();
        int result = RANDOM.nextInt(100) + 1;

        assertTrue(result >= 1 && result <= 100);
    }

    @Test
    public void testInputValue_5_5() {
        Tools tm = new Tools();
        InputStream inputStream = new ByteArrayInputStream(INPUT_5.getBytes());
        Scanner input = new Scanner(inputStream);
        int result = tm.inputValue("variable", input);
        assertEquals(5, result);
    }

    @Test
    public void testInputValue_100_100() {
        Tools tm = new Tools();
        InputStream inputStream = new ByteArrayInputStream(INPUT_100.getBytes());
        Scanner input = new Scanner(inputStream);
        int result = tm.inputValue("variable", input);
        assertEquals(100, result);
    }

}


/*


The provided JUnit tests seem simple and straightforward, but there are a few optimizations that can be done to improve their readability and reliability. Here are some suggestions:

Remove unused imports: The import statement for org.testng.Assert is not used in any of the tests, so it should be removed.

Use constants for hardcoded values: The input strings for the testInputValue_5_5() and testInputValue_100_100() tests are hardcoded as "5\n" and "100\n" respectively. It's better to use constants to avoid repeating the same value in multiple places. For example:

java
Copy code
private static final String INPUT_5 = "5\n";
private static final String INPUT_100 = "100\n";
Use parameterized tests: Instead of having two separate tests for testInputValue_5_5() and testInputValue_100_100(), we can use parameterized tests to test multiple input values in a single test. This reduces code duplication and improves test maintainability. For example:
java
Copy code
@ParameterizedTest
@CsvSource({"5, 5", "100, 100"})
void testInputValue(int input, int expected) {
    Tools tm = new Tools();
    String inputString = input + "\n";
    InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    Scanner scanner = new Scanner(inputStream);
    int result = tm.inputValue("variable", scanner);
    assertEquals(expected, result);
}
Use try-with-resources for input stream and scanner: The input stream and scanner objects created in the testInputValue() method should be closed after the test is completed. A better way to handle this is to use the try-with-resources statement, which automatically closes the resources after the block is executed. For example:
java
Copy code
@ParameterizedTest
@CsvSource({"5, 5", "100, 100"})
void testInputValue(int input, int expected) {
    Tools tm = new Tools();
    String inputString = input + "\n";
    InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    try (Scanner scanner = new Scanner(inputStream)) {
        int result = tm.inputValue("variable", scanner);
        assertEquals(expected, result);
    }
}
Improve test naming: The test method names should clearly indicate what is being tested. The current names like testInputValue_5_5() and testInputValue_100_100() are not very informative. A better naming convention would be shouldReturnCorrectValueForGivenInput().

Add more tests: The existing tests only cover a few cases. To ensure better test coverage, additional test cases can be added, such as testing for negative input values, non-numeric input values, etc.

Overall, the suggested changes improve the readability and reliability of the tests. Here is the optimized code:

java
Copy code
package diophantineMod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToolsTest {

    @Test
    public void shouldThrowArithmeticException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 0;
        });

        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldGenerateRandomIntegerBetween1And100() {

*/