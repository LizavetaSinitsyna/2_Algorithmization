package by.epam.module2.part2;

import java.util.Scanner;

// Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

public class MultidimensionalArrayTask3 {

	public static void main(String[] args) {

		int[][] matrix = { { 3, 4 }, { 6, 7, 8, 9 }, { 2, 3 } };

		int k = readInt("Введите строку k >> ");

		if (k > matrix.length) {
			System.out.println("В матрице меньше строк, чем введенное k.");
		} else {
			System.out.println(k + "-я строка: ");
			for (int i = 0; i < matrix[k - 1].length; i++) {
				System.out.print(matrix[k - 1][i] + " ");
			}
		}

		System.out.println();

		int p = readInt("Введите столбец p >> ");

		System.out.println(p + "-й столбец: ");
		for (int i = 0; i < matrix.length; i++) {
			if (p > matrix[i].length) {
				System.out.println("В матрице в строке " + (i + 1) + " меньше элементов, чем введенное p.");
			} else {
				System.out.print(matrix[i][p - 1] + "\n");
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
