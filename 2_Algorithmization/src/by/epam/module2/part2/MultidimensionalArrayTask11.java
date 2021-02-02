package by.epam.module2.part2;

import java.util.Random;
import java.util.Scanner;

/* Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
которых число 5 встречается три и более раз.
*/

public class MultidimensionalArrayTask11 {

	public static void main(String[] args) {

		int[][] matrix = new int[10][20];

		Random random = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(16);
			}

		}

		System.out.println("Сформирована матрица следующего вида: ");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("Номера строк, в которых число 5 встречается три и более раз:");

		int fiveCounter = 0;
		int rowCounter = 0;

		for (int i = 0; i < matrix.length; i++) {
			fiveCounter = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 5) {
					fiveCounter++;
				}
			}
			if (fiveCounter >= 3) {
				System.out.println(i + 1);
				rowCounter++;
			}
		}
		if (rowCounter == 0) {
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
