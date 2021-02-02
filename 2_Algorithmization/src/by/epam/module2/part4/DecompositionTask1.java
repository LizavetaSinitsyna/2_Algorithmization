package by.epam.module2.part4;

import java.util.Scanner;

/*Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
натуральных чисел:*/

public class DecompositionTask1 {

	public static void main(String[] args) {

		long a;
		long b;

		a = readPositiveLong("Введите натуральное число a >> ");
		b = readPositiveLong("Введите натуральное число b >> ");

		System.out.print("НОД: " + nod(a, b) + " НОК: " + nok(a, b));
	}

	public static long readPositiveLong(String message) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		long number;

		do {
			System.out.println(message);
			while (!scan.hasNextLong()) {
				scan.nextLine();
				System.out.println(message);
			}
			number = scan.nextLong();
			scan.nextLine();
		} while (number < 1);

		return number;
	}

	public static long nod(long a, long b) {
		// Алгоритм Евклида
		while (a != 0 && b != 0) {
			if (a > b) {
				a = a % b;
			} else {
				b = b % a;
			}
		}
		return a + b;
	}

	public static long nok(long a, long b) {
		// Алгоритм Евклида

		return a * b / nod(a, b);

	}

}
