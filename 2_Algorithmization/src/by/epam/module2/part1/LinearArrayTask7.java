package by.epam.module2.part1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Даны действительные числа a1, a2,...a_2n . Найти max(a1 + a_2n, a2 + a_(2n-1),...an + a_(n+1)). 
 */

public class LinearArrayTask7 {

	public static void main(String[] args) {

		int n = readInt("Введите четное количество элементов массива n >> ");

		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = readDouble(">> ");
		}

		System.out.println("Сформирован массив " + Arrays.toString(array));

		double max = array[n / 2 - 1] + array[n / 2]; // an + a_(n+1)
		// System.out.println(max);
		double forComparison = 0;

		for (int i = 0; i < array.length / 2 - 1; i++) {
			forComparison = array[i] + array[n - 1 - i];
			// System.out.println(forComparison);
			max = Math.max(max, forComparison);
		}

		System.out.println("max = " + max);

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
