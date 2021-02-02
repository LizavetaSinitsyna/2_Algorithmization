package by.epam.module2.part4;

import java.util.Scanner;

/*Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m.
*/

public class DecompositionTask8 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");
		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = readDouble(">> ");
		}

		int k = readInt("Введите начальный номер элемента массива k >> ");

		sumOfThreeArrayElements(array, k);

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

	public static void sumOfThreeArrayElements(double[] array, int k) {

		int sum = 0;

		if (array.length < 3) {
			System.out.println("Массив содержит менее 3 элементов.");
			return;
		} else if (array.length < k) {
			System.out.println("В массие меньше элементов, чем заданный начальный номер элемента.");
			return;
		} else if (array.length - 2 < k) {
			System.out.println("В массиве после заданного начального элемента содержится менее 3-х элементов");
			return;
		}

		for (int i = k - 1; i < k + 2; i++) {
			sum += array[i];
		}

		System.out.print(sum);
		
		return;
	}
}
