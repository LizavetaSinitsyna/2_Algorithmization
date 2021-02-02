package by.epam.module2.part2;

import java.util.Scanner;
import java.util.Random;

/*
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца.
*/

public class MultidimensionalArrayTask14 {

	public static void main(String[] args) {

		int m = readInt("Введите количество строк матрицы m >> ");
		int n = readInt("Введите количество столбцов матрицы n >> ");

		int[][] matrix = new int[m][n];

		Random random = new Random();

		int row;
		boolean isFilled = false;

		for (int j = 0; j < n; j++) {
			for (int k = 0; k < Math.min(j + 1, m); k++) {
				while (!isFilled) {
					row = random.nextInt(m);
					if (matrix[row][j] != 1) {
						matrix[row][j] = 1;
						isFilled = true;
					}
				}
				isFilled = false;
			}

		}

		System.out.println("Сформирована матрица следующего вида: ");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		if (n > m) {
			System.out.println("Так как количество строк недостаточно, условие задачи не может быть корректно выполнено"
					+ " для столбцов со следующими номерами: ");
			for (int q = m; q < n; q++) {
				System.out.println(q + 1);
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

}
