package by.epam.module2.part4;

import java.util.Scanner;

/*Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число, 
 * которое меньше максимального элемента массива, но больше всех других элементов).*/

public class DecompositionTask5 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");
		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = readDouble(">> ");
		}

		beforeMaxElement(array);

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

	public static void beforeMaxElement(double[] array) {

		if (array.length == 1) {
			System.out.println("Массив состоит из одного элемента " + array[0]);
			return;
		}

		double max = array[0];

		// Searching for max element

		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		double difMin = max;

		// Searching for minimal difference between max element and other elements of
		// array

		for (int i = 0; i < array.length; i++) {
			if (max - Math.abs(array[i]) < difMin && max != array[i]) {
				difMin = max - array[i];
			}
		}

		double beforeMaxElem = 0;

		if (difMin == max) {
			System.out.println("Массив содержит только равные между собой элементы.");
		} else {
			for (double element : array) {
				if (max - element == difMin) {
					beforeMaxElem = element;
					System.out.println(beforeMaxElem);
					break;
				}

			}
		}

	}
}
