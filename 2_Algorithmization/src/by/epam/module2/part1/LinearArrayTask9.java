package by.epam.module2.part1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */

public class LinearArrayTask9 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");

		long[] array = new long[n];

		for (int i = 0; i < n; i++) {
			array[i] = readLong(">> ");
		}

		System.out.println("Сформирован массив " + Arrays.toString(array));

		if (array.length == 1) {
			System.out.println("Массив состоит только из одного элемента " + array[0]);
			return;
		}

		int countRepetitions = 0;
		int maxAmountOfRepetitions = 0;

		long numberWithMaxAmountOfRepetitions = 0;

		for (int i = 0; i < array.length; i++) {

			countRepetitions = 1;

			for (int j = i + 1; j < array.length - 1; j++) {
				if (array[i] == array[j]) {
					countRepetitions++;
				}
			}
			if (countRepetitions > maxAmountOfRepetitions) {
				maxAmountOfRepetitions = countRepetitions;
				numberWithMaxAmountOfRepetitions = array[i];
			}
		}

		for (int i = 0; i < array.length; i++) {

			countRepetitions = 1;

			for (int j = i + 1; j < array.length - 1; j++) {
				if (array[i] == array[j]) {
					countRepetitions++;
				}
			}
			if (countRepetitions == maxAmountOfRepetitions && array[i] < numberWithMaxAmountOfRepetitions) {
				numberWithMaxAmountOfRepetitions = array[i];
			}
		}

		System.out.println("Наиболее часто встречающееся минимальное число " + numberWithMaxAmountOfRepetitions);

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
