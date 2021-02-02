package by.epam.module2.part4;

import java.util.Arrays;
import java.util.Scanner;

/*Дано натуральное число N. 
 *Написать метод(методы) для формирования массива, элементами которого являются цифры числа N.
*/

public class DecompositionTask10 {

	public static void main(String[] args) {

		int n = readInt("Введите натуральное число n >> ");

		System.out.print(Arrays.toString(arrayFromDigits(n)));
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
		} while (number <= 0);

		return number;
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
