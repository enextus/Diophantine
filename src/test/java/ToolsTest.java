import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

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
