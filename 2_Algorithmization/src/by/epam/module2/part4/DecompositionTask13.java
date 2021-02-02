package by.epam.module2.part4;

import java.util.Scanner;

/*Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43). 
 *Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. 
 *Для решения задачи использовать декомпозицию.
 */

public class DecompositionTask13 {

	public static void main(String[] args) {

		long n = readLong("Введите натуральное число n больше 2, не превышающее " + Long.MAX_VALUE / 2 + " >> ");

		searchingSimpleTwin(n);
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
		} while (number <= 2 && number > Long.MAX_VALUE / 2);

		return number;
	}

	public static void searchingSimpleTwin(long n) {

		long simpleNumber = 0;

		int counter = 0;

		// Searching for the first simple number
		for (long i = n; i <= n * 2; i++) {
			if (isSimple(i)) {
				simpleNumber = i;
				break;
			}
		}

		System.out.println("Простые числа-близнецы в диапазоне [" + n + ", " + (n * 2) + "]:");

		for (long i = simpleNumber + 1; i <= n * 2; i++) {
			if (isSimple(i)) {
				if (isTwin(simpleNumber, i)) {
					System.out.println(simpleNumber + " и " + i);
					counter++;
				}
				simpleNumber = i;
			}
		}

		if (counter == 0) {
			System.out.println("Отсутствуют.");
		}

	}

	public static boolean isTwin(long current, long next) {

		if (next - current == 2) {
			return true;
		}

		return false;

	}

	public static boolean isSimple(long number) {

		for (long i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;

	}

}
