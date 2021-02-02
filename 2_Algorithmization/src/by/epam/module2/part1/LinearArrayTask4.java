package by.epam.module2.part1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */

public class LinearArrayTask4 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");

		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = readDouble(">> ");
		}

		System.out.println("Сформирован массив " + Arrays.toString(array));

		double max = array[0];
		double min = array[0];

		int maxIndex = 0;
		int minIndex = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}

		array[maxIndex] = min;
		array[minIndex] = max;

		System.out.println("Mассив после смены мест наибольшего и наименьшего элементов: " + Arrays.toString(array));

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
