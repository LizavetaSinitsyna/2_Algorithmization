package by.epam.module2.part4;

import java.util.Scanner;

/*Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. 
 *Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 */

public class DecompositionTask17 {

	public static void main(String[] args) {

		long n = readLong("Введите число n >> ");

		System.out.println("Необходимое количество действий равно " + minusSumOfDigits(n) + ".");

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
		} while (number < 0);

		return number;
	}

	public static int minusSumOfDigits(long n) {
		int counter = 0;

		long number = n;

		while (number > 0) {
			number -= sumOfDigits(number);
			counter++;
		}

		return counter;

	}

	public static int sumOfDigits(long n) {

		int sum = 0;
		
		int amountOfDigits = countDigits(n);

		for (int i = 0; i < amountOfDigits; i++) {
			sum += (int) n % 10;
			n /= 10;
		}

		return sum;

	}

	public static int countDigits(long n) {
		int counter = 0;
		while (n != 0) {
			n /= 10;
			counter++;
		}
		return counter;

	}

}