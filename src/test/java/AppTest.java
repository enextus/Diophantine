import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
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

    @Test
    void testFindSolution() {
        List<int[]> solutions = DiophantineSolver.findSolution(1, 1, 1, 6);

        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{1, 2, 3}));
        assertTrue(containsSolution(solutions, new int[]{3, 2, 1}));
    }

    // Проверяет, что ваш решатель корректно сообщает об отсутствии решения.
    @Test
    void testFindSolutionNoSolution() {
        List<int[]> solutions = DiophantineSolver.findSolution(2, 2, 2, 1);

        assertTrue(solutions.isEmpty()); // Ожидается отсутствие решения
    }

    // Проверяет, что ваш решатель может обрабатывать случай, когда d=0.
    @Test
    void testFindSolutionZeroD() {
        List<int[]> solutions = DiophantineSolver.findSolution(1, 1, 1, 0);

        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{0, 0, 0}));
    }


/*
    @Test
    void testFindSolutionNegativeCoefficients() {
        List<int[]> solutions = DiophantineSolver.findSolution(-1, -1, -1, -6);
        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{-1, -2, -3}));
        assertTrue(containsSolution(solutions, new int[]{-3, -2, -1}));
    }
*/

/*    @Test
    void testFindSolutionMixedCoefficients() {
        List<int[]> solutions = DiophantineSolver.findSolution(-1, 1, 1, 3);
        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{-3, 1, 5}));
        assertTrue(containsSolution(solutions, new int[]{-1, 1, 3}));
    }*/


/*
    @Test
    void testFindSolutionBigNumbers() {
        List<int[]> solutions = DiophantineSolver.findSolution(1000, 1000, 1000, 3000);
        assertFalse(solutions.isEmpty());
        assertTrue(containsSolution(solutions, new int[]{1000, 1000, 1000}));
    }
*/

}


