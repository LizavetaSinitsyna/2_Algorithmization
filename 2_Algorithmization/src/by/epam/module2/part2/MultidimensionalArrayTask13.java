package by.epam.module2.part2;

import java.util.Scanner;

// Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов.

public class MultidimensionalArrayTask13 {

	public static void main(String[] args) {

		int m = readInt("Введите количество строк матрицы m >> ");
		int n = readInt("Введите количество столбцов матрицы n >> ");

		double[][] matrix = new double[m][n];

		for (int i = 0; i < m; i++) {
			System.out.print("Введите элементы " + (i + 1) + "-й строки ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = readDouble(">> ");
			}

		}

		System.out.println("Сформирована матрица следующего вида: ");

		printMatrix(matrix);

		System.out.println("Матрица с отсортированными по убыванию элементами столбцов: ");

		double temp = matrix[0][0];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < matrix.length - 1; j++) {
				for (int k = 0; k < matrix[i].length - 1 - j; k++)
					if (matrix[k][i] < matrix[k + 1][i]) {
						temp = matrix[k][i];
						matrix[k][i] = matrix[k + 1][i];
						matrix[k + 1][i] = temp;
					}
			}
		}

		printMatrix(matrix);

		System.out.println("Матрица с отсортированными по возрастанию элементами столбцов: ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < matrix.length - 1; j++) {
				for (int k = 0; k < matrix[i].length - 1 - j; k++)
					if (matrix[k][i] > matrix[k + 1][i]) {
						temp = matrix[k][i];
						matrix[k][i] = matrix[k + 1][i];
						matrix[k + 1][i] = temp;
					}
			}
		}

		printMatrix(matrix);

	}

	public static int readInt(String message) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int number;
		do {
			System.out.println(message);

			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println(message);
			}

			number = scan.nextInt();
			scan.nextLine();
		} while (number < 1);

		return number;
	}

	public static double readDouble(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		double number;

		do {
			System.out.println(message);

			while (!scan.hasNextDouble()) {
				scan.nextLine();
				System.out.println(message);
			}

			number = scan.nextDouble();
			scan.nextLine();
		} while (!сheckDoubleValidation(number));

		return number;
	}

	public static boolean сheckDoubleValidation(double value) {

		if (value > Double.MAX_VALUE || value < -Double.MAX_VALUE) {
			System.out.println("The value is out of range for double.");
			return false;
		}
		return true;
	}

	public static void printMatrix(double[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
