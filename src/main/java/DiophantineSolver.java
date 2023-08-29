import java.util.ArrayList;
import java.util.List;

public class DiophantineSolver {
    public static List<int[]> findSolution(int a, int b, int c, int d) {
        List<int[]> solutions = new ArrayList<>();

        for (int x = -d / Math.abs(a); x <= d / Math.abs(a); x++) {
            for (int y = -d / Math.abs(b); y <= d / Math.abs(b); y++) {
                for (int z = -d / Math.abs(c); z <= d / Math.abs(c); z++) {
                    if (a * x + b * y + c * z == d) solutions.add(new int[]{x, y, z});
                }
            }
        }

        for (int[] solution : solutions) {
            System.out.printf("Solution: x = %d, y = %d, z = %d%n", solution[0], solution[1], solution[2]);
        }

        return solutions;
    }

}
