// Реализация метода Гаусса-Зейделя на Java

import java.io.PrintWriter;
import java.util.Arrays;

class GFG {
	// Задаем максимальное количество итераций для предотвращения бесконечного цикла
	public static final int MAX_ITERATIONS = 100;
	private double[][] M;

	// Конструктор для инициализации матрицы
	public GFG(double[][] matrix) {
		M = matrix;
	}

	// Метод для вывода матрицы
	public void print() {
		int n = M.length;
		for (double[] doubles : M) {
			for (int j = 0; j < n + 1; j++) System.out.print(doubles[j] + " ");
			System.out.println();
		}
	}

	// Метод для преобразования матрицы в диагонально доминирующую (если это возможно)
	public boolean transformToDominant(int r, boolean[] V, int[] R) {
		int n = M.length;

		if (r == M.length) {
			double[][] T = new double[n][n + 1];

			for (int i = 0; i < R.length; i++) System.arraycopy(M[R[i]], 0, T[i], 0, n + 1);

			M = T;
			return true;
		}

		for (int i = 0; i < n; i++) {
			if (V[i]) continue;
			double sum = 0;
			for (int j = 0; j < n; j++) sum += Math.abs(M[i][j]);

			if (2 * Math.abs(M[i][r]) > sum) {
				V[i] = true;
				R[r] = i;
				if (transformToDominant(r + 1, V, R)) return true;
				V[i] = false;
			}
		}
		return false;
	}

	// Метод для проверки, является ли матрица диагонально доминирующей
	public boolean makeDominant() {
		boolean[] visited = new boolean[M.length];
		int[] rows = new int[M.length];
		Arrays.fill(visited, false);
		return transformToDominant(0, visited, rows);
	}

	// Метод для нахождения решения системы уравнений после выполнения всех условий
	public void solve() {
		int iterations = 0;
		int n = M.length;
		double epsilon = 1e-15;
		double[] X = new double[n]; // Текущие приближения
		double[] P = new double[n]; // Предыдущие значения

		Arrays.fill(X, 0);

		System.out.println("X size: " + X.length);

		for (double el : X) System.out.println("el: " + el);

		while (true) {
			// Реализация итераций метода Гаусса-Зейделя
			for (int i = 0; i < n; i++) {
				double sum = M[i][n];
				for (int j = 0; j < n; j++)
					if (j != i)
						sum -= M[i][j] * X[j];
				X[i] = 1 / M[i][i] * sum;
			}

			// Вывод текущего приближения
			System.out.print("X" + iterations + " = {");
			for (int i = 0; i < n; i++) System.out.print(X[i] + " ");

			System.out.println("}");
			iterations++;

			// Условия остановки
			if (iterations == 1) continue;
			boolean stop = true;
			for (int i = 0; i < n && stop; i++)
				if (Math.abs(X[i] - P[i]) > epsilon) {
					stop = false;
					break;
				}

			if (stop || iterations == MAX_ITERATIONS) break;

			// Обновление массива предыдущих значений без полного копирования
			System.arraycopy(X, 0, P, 0, n);
		}
	}

	// Точка входа в программу
	public static void main(String[] args) {
		PrintWriter writer = new PrintWriter(System.out, true);

		// Создается двумерный массив M размером 2 x 3:
		int n = 2, k = 1;
		double[][] M = new double[n][n + 1];

		// Здесь вы создаете матрицу M с числом строк n и числом столбцов n + 1.
		// Значения этой матрицы устанавливаются на основе переменной k,
		// которая начинается с 1 и увеличивается на 1 с каждым новым элементом.
		// В итоге матрица M будет выглядеть следующим образом:
		// 1 2 3
		// 4 5 6
		// Это значит, что ваша система уравнений будет такова:

		// 1*X1 + 2*X2 = 3
		// 4*X1 + 5*X2 = 6

		// Инициализация матрицы
		for (int i = 0; i < n; i++) for (int j = 0; j < n + 1; j++) M[i][j] = k++;

		// Создание объекта класса GFG и решение системы уравнений
		GFG gausSeidel = new GFG(M);

		if (!gausSeidel.makeDominant())
			writer.println("Система не является диагонально доминирующей: метод не может гарантировать сходимость.");

		writer.println();
		gausSeidel.print();
		gausSeidel.solve();
	}

}
