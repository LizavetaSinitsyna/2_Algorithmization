package by.epam.module2.part4;

import java.util.Scanner;

//Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

public class DecompositionTask11 {

	public static void main(String[] args) {

		long x = readLong("Введите целое число x >> ");
		long y = readLong("Введите целое число y >> ");

		compareAmountOfDigits(x, y);
	}

	public static long readLong(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		long number = 0;

		System.out.println(message);

		while (!scan.hasNextLong()) {
			scan.nextLine();
			System.out.println(message);
		}

		number = scan.nextLong();

		return number;
	}

	public static void compareAmountOfDigits(long x, long y) {

		int firstNumberLength = countDigits(Math.abs(x));
		int secondNumberLength = countDigits(Math.abs(y));

		long result = firstNumberLength > secondNumberLength ? x : y;

		if (firstNumberLength == secondNumberLength) {
			System.out.println("Количество цифр в двух числах одинаковое.");
		} else {
			System.out.println("Количество цифр больше в числе " + result);
		}

	}

	public static int countDigits(long n) {
		int counter = 0;
		if (n == 0) {
			counter = 1;
		}
		while (n != 0) {
			n /= 10;
			counter++;
		}
		return counter;

	}

}
