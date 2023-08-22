import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiophantineTest {
    @Test
    void testFindSolution() {
        List<int[]> solutions = Diophantine.findSolution(1, 1, 1, 6);
        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{1, 2, 3}));
        assertTrue(containsSolution(solutions, new int[]{3, 2, 1}));

    }

/*    @Test
    void testFindSolution_2() {
        List<int[]> solutions = Diophantine.findSolution(2, 3, 5, 23);
        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{1, 5, 1}));
        assertTrue(containsSolution(solutions, new int[]{5, 1, 1}));

    }

    @Test
    void testFindSolution_3() {
        List<int[]> solutions = Diophantine.findSolution(1, 2, 3, 4);
        assertTrue(solutions.isEmpty());
    }*/

    public boolean containsSolution(List<int[]> solutions, int[] target) {
        Arrays.sort(target);  // Сортируем целевой массив

        for (int[] solution : solutions) {
            if (solution.length == target.length) {
                int[] sortedSolution = Arrays.copyOf(solution, solution.length);
                Arrays.sort(sortedSolution);  // Сортируем текущий массив решений

                if (Arrays.equals(sortedSolution, target)) {
                    return true;  // Решение найдено
                }
            }
        }
        return false;  // Решение не найдено
    }

}
