// Implementation of Gauss-Seidel method in Java

import java.io.PrintWriter;
import java.util.Arrays;

class GFG {
	// Set the maximum number of iterations to prevent infinite loop
	public static final int MAX_ITERATIONS = 100;
	private double[][] M;

	// Constructor to initialize the matrix
	public GFG(double[][] matrix) {
		M = matrix;
	}

	// Method to print the matrix
	public void print() {
		int n = M.length;
		for (double[] row : M) {
			for (int j = 0; j < n + 1; j++) System.out.print(row[j] + " ");
			System.out.println();
		}
	}

	// Method to transform the matrix into diagonally dominant form (if possible)
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

	// Method to check if the matrix is diagonally dominant
	public boolean makeDominant() {
		boolean[] visited = new boolean[M.length];
		int[] rows = new int[M.length];
		Arrays.fill(visited, false);
		return transformToDominant(0, visited, rows);
	}

	// Method to find the solution to the system of equations after satisfying all conditions
	public void solve() {
		int iterations = 0;
		int n = M.length;
		double epsilon = 1e-15;
		double[] X = new double[n]; // Current approximations
		double[] P = new double[n]; // Previous values

		Arrays.fill(X, 0);

		System.out.println("X size: " + X.length);

		for (double el : X) System.out.println("el: " + el);

		while (true) {
			// Implementation of Gauss-Seidel iterations
			for (int i = 0; i < n; i++) {
				double sum = M[i][n];
				for (int j = 0; j < n; j++)
					if (j != i)
						sum -= M[i][j] * X[j];
				X[i] = 1 / M[i][i] * sum;
			}

			// Print the current approximation
			System.out.print("X" + iterations + " = {");
			for (int i = 0; i < n; i++) System.out.print(X[i] + " ");

			System.out.println("}");
			iterations++;

			// Stopping conditions
			if (iterations == 1) continue;
			boolean stop = true;

			for (int i = 0; i < n && stop; i++)
				if (Math.abs(X[i] - P[i]) > epsilon) {
					stop = false;
					break;
				}

			if (stop || iterations == MAX_ITERATIONS) break;

			// Update the array of previous values without full copying
			System.arraycopy(X, 0, P, 0, n);
		}
	}

	// Entry point of the program
	public static void main(String[] args) {
		PrintWriter writer = new PrintWriter(System.out, true);

		// Create a 2x3 matrix M:
		int n = 2, k = 1;
		double[][] M = new double[n][n + 1];

		// Here, you create matrix M with n rows and n + 1 columns.
		// The values of this matrix are set based on variable k,
		// which starts from 1 and increments by 1 for each new element.
		// Eventually, matrix M will look like this:
		// 1 2 3
		// 4 5 6
		// This means that your system of equations will be as follows:

		// 1*X1 + 2*X2 = 3
		// 4*X1 + 5*X2 = 6

		// Initialize the matrix
		for (int i = 0; i < n; i++) for (int j = 0; j < n + 1; j++) M[i][j] = k++;

		// Create an object of the GFG class and solve the system of equations
		GFG gaussSeidel = new GFG(M);

		if (!gaussSeidel.makeDominant())
			writer.println("The system is not diagonally dominant: the method cannot guarantee convergence.");

		writer.println();
		gaussSeidel.print();
		gaussSeidel.solve();
	}
}
