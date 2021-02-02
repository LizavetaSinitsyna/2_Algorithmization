package by.epam.module2.part2;

import java.util.Scanner;

// Найти положительные элементы главной диагонали квадратной матрицы.

public class MultidimensionalArrayTask10 {

	public static void main(String[] args) {

		int m = readInt("Введите количество строк и столбцов квадратной матрицы m >> ");

		double[][] matrix = new double[m][m];

		for (int i = 0; i < m; i++) {
			System.out.print("Введите элементы " + (i + 1) + "-й строки ");
			for (int j = 0; j < m; j++) {
				matrix[i][j] = readDouble(">> ");
			}

		}

		System.out.println("Сформирована матрица следующего вида: ");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("Положительные элементы, стоящие на диагонали:");

		for (int i = 0; i < matrix.length; i++) {

			if (matrix[i][i] > 0) {
				System.out.print(matrix[i][i] + " ");
			}

		}

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

}
