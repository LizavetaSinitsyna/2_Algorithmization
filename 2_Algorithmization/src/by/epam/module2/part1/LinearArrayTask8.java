package by.epam.module2.part1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Дана последовательность целых чисел a1, a2,..., a_n. Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min(a1, a2,..., a_n).
 */

public class LinearArrayTask8 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");

		long[] array = new long[n];

		for (int i = 0; i < n; i++) {
			array[i] = readLong(">> ");
		}

		System.out.println("Сформирован массив " + Arrays.toString(array));

		long min = array[0];

		int counter = 0;

		// Searching for minimal element

		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}

		// Count the amount of minimal elements

		for (int i = 0; i < array.length; i++) {
			if (array[i] == min) {
				counter++;
			}
		}

		// Creating array without minimal elements

		long[] newArray = new long[array.length - counter];

		int j = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != min) {
				newArray[j] = array[i];
				j++;
			}
		}

		System.out.println("Сформирован новый массив " + Arrays.toString(newArray));

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
