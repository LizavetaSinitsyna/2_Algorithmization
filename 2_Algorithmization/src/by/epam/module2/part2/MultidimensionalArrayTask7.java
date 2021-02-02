package by.epam.module2.part2;

import java.util.Scanner;

// Сформировать квадратную матрицу порядка N по правилу: и подсчитать количество положительных элементов в ней.

public class MultidimensionalArrayTask7 {

	public static void main(String[] args) {

		int n = readInt("Введите n >> ");

		double[][] matrix = new double[n][n];

		int counter = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				matrix[i][j] = Math.sin((i * i - j * j) / (double) n);
				if (matrix[i][j] > 0) {
					counter++;
				}
			}

		}

		System.out.println("Сформирована матрица следующего вида: ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("В матрице содержится следующее количество положительных элементов: " + counter);

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

}
