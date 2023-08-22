import diophantineMod.Diophantine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class DiophantineTest {

    @Test
    void testFindSolution() {
        List<int[]> solutions = Diophantine.findSolution(1, 1, 1, 6);
        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{1, 2, 3}));
        assertTrue(containsSolution(solutions, new int[]{3, 2, 1}));

        solutions = Diophantine.findSolution(2, 3, 5, 23);
        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{1, 5, 1}));
        assertTrue(containsSolution(solutions, new int[]{5, 1, 1}));

        solutions = Diophantine.findSolution(1, 2, 3, 4);
        assertTrue(solutions.isEmpty());
    }

    public boolean containsSolution(List<int[]> solutions, int[] target) {
        for (int[] solution : solutions) {
            if (solution.length == target.length) {
                boolean equal = true;
                for (int i = 0; i < solution.length; i++) {
                    if (solution[i] != target[i]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) return true;
            }
        }
        return false;
    }
}
