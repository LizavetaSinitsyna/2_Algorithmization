package by.epam.module2.part1;

import java.util.Scanner;

/*
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */

public class LinearArrayTask1 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt(">> ");
		}

		int k = readInt("Введите число k >> ");

		System.out.print("Сумма элементов массива, кратных " + k + ", равна " + sumOfMultipleElements(array, k));

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

	public static int sumOfMultipleElements(int[] array, int k) {

		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] % k == 0) {
				sum += array[i];
			}
		}
		return sum;
	}

}
