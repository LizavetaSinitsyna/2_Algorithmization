package by.epam.module2.part1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */

public class LinearArrayTask10 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");

		long[] array = new long[n];

		for (int i = 0; i < n; i++) {
			array[i] = readLong(">> ");
		}

		System.out.println("Сформирован массив " + Arrays.toString(array));

		for (int i = 0; i < (array.length + 1) / 2; i++) {
			if (i == 1 || i / 2 != 0) {
				array[i] = array[i * 2];
			} else {
				continue;
			}

		}

		for (int i = (array.length + 1) / 2; i < array.length; i++) {

			array[i] = 0;

		}

		System.out.println("Массив после сжатия " + Arrays.toString(array));

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
