package by.epam.module2.part1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */

public class LinearArrayTask3 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");
		int positive = 0;
		int negative = 0;
		int zero = 0;

		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = readDouble(">> ");
		}

		System.out
				.println("Сформирован массив " + Arrays.toString(array) + " в котором содержится следующее количество элементов: ");

		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				positive++;
			} else if (array[i] == 0) {
				zero++;
			} else {
				negative++;
			}
		}

		System.out.println("положительных - " + positive);
		System.out.println("отрицательных - " + negative);
		System.out.println("нулевых - " + zero);

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
