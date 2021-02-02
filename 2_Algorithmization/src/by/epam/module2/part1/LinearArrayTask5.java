package by.epam.module2.part1;

import java.util.Scanner;

/*
 * Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */

public class LinearArrayTask5 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");

		long[] array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = readLong(">> ");
		}

		System.out.println("Элементы массива, для которых i-й элемент > i:");

		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) {
				System.out.println(array[i]);
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

	public static long readLong(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		long number;

		System.out.println(message);

		while (!scan.hasNextLong()) {
			scan.nextLine();
			System.out.println(message);
		}

		number = scan.nextLong();

		return number;
	}

}
