package by.epam.module2.part4;

import java.util.Scanner;

/*Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, 
 *возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. 
 *Для решения задачи использовать декомпозицию.
 */

public class DecompositionTask14 {

	public static void main(String[] args) {

		long k = readLong("Введите натуральное число n >> ");

		printingArmstrongNumber(k);

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
		} while (number <= 1);

		return number;
	}

	public static void printingArmstrongNumber(long k) {

		System.out.println("Числа Армстронга в пределах от 1 до " + k + ":");

		for (long i = 1; i <= k; i++) {
			if (isArmstrongNumber(i)) {
				System.out.println(i);
			}
		}

	}

	public static boolean isArmstrongNumber(long number) {

		if (sumOfDigitInDegree(number) == number) {
			return true;
		}

		return false;

	}

	public static int sumOfDigitInDegree(long number) {
		int sum = 0;
		int degree = countDigits(number);

		while (number != 0) {
			sum += Math.pow(number % 10, degree);
			number /= 10;
		}

		return sum;

	}

	public static int countDigits(long number) {
		int counter = 0;
		if (number == 0) {
			counter = 1;
		}
		while (number != 0) {
			number /= 10;
			counter++;
		}
		return counter;

	}

}