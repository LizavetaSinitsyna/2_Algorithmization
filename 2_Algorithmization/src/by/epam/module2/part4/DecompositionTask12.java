package by.epam.module2.part4;

import java.util.Arrays;
import java.util.Scanner;

/*Даны натуральные числа К и N. Написать метод(методы) формирования массива А, 
 *элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
 */

public class DecompositionTask12 {

	public static void main(String[] args) {

		long k = readLong("Введите натуральное число k >> ");
		long n = readLong("Введите натуральное число n >> ");

		arrayBuild(k, n);
	}

	public static long readLong(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		long number = 0;

		do {
			System.out.println(message);

			while (!scan.hasNextLong()) {
				scan.nextLine();
				System.out.println(message);
			}

			number = scan.nextLong();
			scan.nextLine();
		} while (number <= 0);

		return number;
	}

	public static void arrayBuild(long k, long n) {

		int arrayLength = arrayLength(k, n);
		if (arrayLength == 0) {
			System.out.println("Числа, соответствующие условию для формирования массива, отсутствуют.");
			return;
		}

		long[] array = new long[arrayLength];

		int j = 0;

		for (long i = 1; i <= n; i++) {

			if (sumOfDigits(i) == k) {
				array[j] = i;
				j++;
			}
		}

		System.out.println(Arrays.toString(array));

	}

	public static int arrayLength(long k, long n) {

		int counter = 0;

		for (long i = 1; i <= n; i++) {
			if (sumOfDigits(i) == k) {
				counter++;
			}
		}

		return counter;

	}

	public static int sumOfDigits(long number) {
		int sum = 0;

		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}

		return sum;

	}

}
