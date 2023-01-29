package DiophantineMod;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import static org.testng.Assert.*;

public class ToolsTest {

    @Test
    public void testGenInteger() {
        final Random RANDOM = new Random();
        int result = RANDOM.nextInt(100) + 1;
        assertTrue(result >= 1 && result <= 100);
    }

    @Test
    public void testInputValue_5_5() {
        Tools tm = new Tools();
        String inputString = "5\n";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner input = new Scanner(inputStream);
        int result = tm.inputValue("variable", input);
        assertEquals(5, result);
    }

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
