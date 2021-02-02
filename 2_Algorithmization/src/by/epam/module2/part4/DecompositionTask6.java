package by.epam.module2.part4;

import java.util.Scanner;

/*Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.*/

public class DecompositionTask6 {

	public static void main(String[] args) {

		long a = readLong("a >> ");
		long b = readLong("b >> ");
		long c = readLong("c >> ");

		System.out.println(isMutuallySimple(a, b, c) ? "Введенные числа являются взаимно простыми"
				: "Введенные числа не являются взаимно простыми");
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

	public static boolean isMutuallySimple(long a, long b, long c) {
		// Алгоритм Евклида
		return nod2(nod2(Math.abs(a), Math.abs(b)), Math.abs(c)) == 1;
	}

}
