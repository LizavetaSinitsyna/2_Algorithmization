package by.epam.module2.part4;

import java.util.Scanner;

/*Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность (например, 1234, 5789). 
 *Для решения задачи использовать декомпозицию.
 */

public class DecompositionTask15 {

	public static void main(String[] args) {

		int n = readInt("Введите натуральное число n, обозначающее количество цифр в числе >> ");

		numbersWithAscendingOrderOfDigits(n);

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

	public static void numbersWithAscendingOrderOfDigits(int n) {

		System.out.println("Натуральные " + n
				+ "-значные числа, цифры в которых образуют строго возрастающую последовательность:");

		for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
			if (isAscendingOrder(arrayFromDigits(i))) {
				System.out.println(i);
			}
		}

	}

	public static boolean isAscendingOrder(int[] digits) {

		int digit = digits[0];
		boolean result = false;

		for (int i = 1; i < digits.length; i++) {
			if (digits[i] < digit) { // Sign "<" because the first digit is the last element in the array of digits
				result = true;
				digit = digits[i];
			} else {
				return false;
			}
		}

		return result;

	}

	public static int[] arrayFromDigits(int n) {

		int arrayLength = countDigits(n);
		int[] digits = new int[arrayLength];

		for (int i = 0; i < digits.length; i++) {
			digits[i] = n % 10;
			n /= 10;
		}

		return digits;

	}

	public static int countDigits(int n) {
		int counter = 0;
		while (n != 0) {
			n /= 10;
			counter++;
		}
		return counter;

	}

}