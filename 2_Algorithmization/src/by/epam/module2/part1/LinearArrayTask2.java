package by.epam.module2.part1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, 
 * большие данного Z, этим числом. Подсчитать количество замен.
 */

public class LinearArrayTask2 {

	public static void main(String[] args) {

		int n = readInt("Введите количество элементов массива n >> ");

		double [] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = readDouble(">> ");
		}

		System.out.println("Сформирован массив " + Arrays.toString(array));

		double z = readDouble("Введите число z >> ");

		System.out.println("Количество замен равно " + replace(array, z));
		
		System.out.println("После замены получен массив " + Arrays.toString(array));

	}

	public static int readInt(String message) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int number;
		do {
			System.out.println(message);

			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println(message);
			}

			number = scan.nextInt();
			scan.nextLine();
		} while (number < 1);

		return number;
	}
	
	public static double readDouble(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		double number;

		do {
			System.out.println(message);

			while (!scan.hasNextDouble()) {
				scan.nextLine();
				System.out.println(message);
			}

			number = scan.nextDouble();
		} while (!сheckDoubleValidation(number));

		return number;
	}

	public static boolean сheckDoubleValidation(double value) {

		if (value > Double.MAX_VALUE || value < -Double.MAX_VALUE) {
			System.out.println("The value is out of range for double.");
			return false;
		}
		return true;
	}

	public static int replace(double[] array, double z) {

		int  counter = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > z) {
				array[i] = z;
				counter++;
			}
		}
		return counter;
	}

}
