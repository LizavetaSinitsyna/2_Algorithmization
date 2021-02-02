package by.epam.module2.part4;

import java.util.Scanner;

/*Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. 
 *Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */

public class DecompositionTask16 {

	public static void main(String[] args) {

		int n = readInt("Введите число n, обозначающее количество цифр в числе >> ");
		long sum = sumOfNumbersWithOddDigits(n);
		amountOfEvenDigits(sum);

	}

	public static int readInt(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int number = 0;

		do {
			System.out.println(message);

			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println(message);
			}

			number = scan.nextInt();
			scan.nextLine();
		} while (number <= 1 || number > 9);

		return number;
	}

	public static long sumOfNumbersWithOddDigits(int n) {

		long sum = 0;

		for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
			if (containsOnlyOddDigits(arrayOfDigits(i))) {
				System.out.println(i);
				sum += i;
			}
		}

		System.out.println("Сумма " + n + "-значных чисел, содержащих только нечетные цифры, равна " + sum);

		return sum;

	}

	public static int amountOfEvenDigits(long number) {

		int counter = 0;

		int[] digits = new int[countDigits(number)];

		digits = arrayOfDigits(number);

		for (int i = 0; i < digits.length; i++) {
			if (!isOdd(digits[i])) {
				counter++;
			}
		}

		System.out.println("В найденной сумме количество четных цифр равно " + counter + ".");

		return counter;

	}

	public static boolean containsOnlyOddDigits(int[] number) {

		boolean result = false;

		for (int i = 0; i < number.length; i++) {
			if (isOdd(number[i])) {
				result = true;
			} else {
				return false;
			}
		}

		return result;

	}

	public static boolean isOdd(int digit) {

		if (digit % 2 == 0) {
			return false;
		}

		return true;

	}

	public static int[] arrayOfDigits(long n) {

		int arrayLength = countDigits(n);
		int[] digits = new int[arrayLength];

		for (int i = 0; i < digits.length; i++) {
			digits[i] = (int) n % 10;
			n /= 10;
		}

		return digits;

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