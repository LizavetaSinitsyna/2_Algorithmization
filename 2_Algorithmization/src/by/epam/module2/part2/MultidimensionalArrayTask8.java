package by.epam.module2.part2;

import java.util.Scanner;

/* В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
пользователь с клавиатуры.
*/

public class MultidimensionalArrayTask8 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 3, 8 }, { 9, 10, 11 }, { 32, 4 }, { 45, -3, 0, -10 } };

		System.out.println("Задана матрица: ");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		int n = readInt("Введите номер первого столбца >> ");
		int m = readInt("Введите номер второго столбца >> ");

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length < n || matrix[i].length < m) {
				System.out.println("Столбцы нельзя поменять местами, так как не все элементы столбца заданы.");
				return;
			}

		}

		int temp;

		for (int i = 0; i < matrix.length; i++) {
			temp = matrix[i][n - 1];
			matrix[i][n - 1] = matrix[i][m - 1];
			matrix[i][m - 1] = temp;

		}

		System.out.println("После перестановки столбцов сформирована матрица следующего вида: ");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
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
		} while (number < 1);

		return number;
	}

}
