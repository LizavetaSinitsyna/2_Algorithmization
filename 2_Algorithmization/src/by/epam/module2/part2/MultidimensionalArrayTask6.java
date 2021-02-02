package by.epam.module2.part2;

import java.util.Scanner;

// Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):

public class MultidimensionalArrayTask6 {

	public static void main(String[] args) {

		int n = readInt("Введите четное n >> ");

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n / 2; i++) {

			for (int j = 0 + i; j < n - i; j++) {
				matrix[i][j] = 1;
				matrix[n - 1 - i][j] = 1;
			}

		}

		System.out.println("Сформирована матрица следующего вида: ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
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
		} while (number < 1 || number % 2 != 0);

		return number;
	}

}
