package by.epam.module2.part2;

import java.util.Scanner;

// Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.

public class MultidimensionalArrayTask1 {

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

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("Нечетные столбцы, у которых первый элемент больше последнего:");

		int counter = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j += 2) {
				if (matrix[0][j] > matrix[matrix.length - 1][j]) {
					System.out.print(matrix[i][j] + "\t");
					counter++;
				}
			}
			if (counter > 0) {
				System.out.println();
			}
		}

		if (counter < 1) {
			System.out.println("Отсутствуют.");
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
