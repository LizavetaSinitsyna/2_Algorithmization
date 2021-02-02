package by.epam.module2.part4;

import java.util.Scanner;

/*Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.*/

public class DecompositionTask2 {

	public static void main(String[] args) {

		long a = readPositiveLong("a >> ");
		long b = readPositiveLong("b >> ");
		long c = readPositiveLong("c >> ");
		long d = readPositiveLong("d >> ");

		System.out.println("НОД: " + nod4(a, b, c, d));
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

	public static long nod2(long a, long b) {
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

	public static long nod4(long a, long b, long c, long d) {
		// Алгоритм Евклида
		return nod2(nod2(nod2(a, b), c), d);
	}

}
