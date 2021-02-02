package by.epam.module2.part4;

import java.util.Arrays;
import java.util.Scanner;

/*На плоскости заданы своими координатами n точек. Написать метод(методы), 
 *определяющие, между какими из пар точек самое большое расстояние. 
 *Указание. Координаты точек занести в массив.*/

public class DecompositionTask4 {

	public static void main(String[] args) {
		int n = readInt("Введите количество точек n >> ");
		double[][] array = new double[n][2];
		for (int i = 0; i < n; i++) {
			array[i][0] = readDouble("x >> ");
			array[i][1] = readDouble("y >> ");

		}

		maxLength(array);

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
			scan.nextLine();
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

	public static double[][][] maxLength(double[][] array) {
		double max = 0;
		double length = 0;
		double max_X2 = 0;
		double max_X1 = 0;
		double max_Y2 = 0;
		double max_Y1 = 0;

		// Searching for max length by calculating the distance between all possible
		// pairs of dots

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				length = Math.sqrt(Math.pow(array[j][0] - array[i][0], 2) + Math.pow(array[j][1] - array[i][1], 2));
				if (length > max) {
					max = length;
					max_X2 = array[j][0];
					max_X1 = array[i][0];
					max_Y2 = array[j][1];
					max_Y1 = array[i][1];
				}
			}

		}

		/*
		 * Creating an array for saving coordinates of dots pairs [[[ max_X1, max_Y1], [
		 * max_X2, max_Y2]] [[ max_X1, max_Y1], [ max_X2, max_Y2]]...]
		 */

		double[][][] arrayWithMaxValue = new double[array.length][2][2];
		arrayWithMaxValue[0][0][0] = max_X2;
		arrayWithMaxValue[0][0][1] = max_Y2;
		arrayWithMaxValue[0][1][0] = max_X1;
		arrayWithMaxValue[0][1][1] = max_Y1;

		int counter = 0;

		/*
		 * Checking an array for dots pairs' coordinates because it can be more than one
		 * pair of dots with max length.
		 */

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				length = Math.sqrt(Math.pow(array[j][0] - array[i][0], 2) + Math.pow(array[j][1] - array[i][1], 2));
				if (length == max) {
					counter++;
					if (counter == 1) {
						continue; // As the first pair of dots with max destination between them is already saved
					} else {
						max_X2 = array[j][0];
						max_X1 = array[i][0];
						max_Y2 = array[j][1];
						max_Y1 = array[i][1];
						arrayWithMaxValue[counter - 1][0][0] = max_X2;
						arrayWithMaxValue[counter - 1][0][1] = max_Y2;
						arrayWithMaxValue[counter - 1][1][0] = max_X1;
						arrayWithMaxValue[counter - 1][1][1] = max_Y1;

					}

				}
			}

		}
		System.out.println("Максимальное расстояние " + max + " между двумя точками со следующими координатами: ");
		for (int i = 0; i < counter; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(Arrays.toString(arrayWithMaxValue[i][j]));
			}
			System.out.println();
		}
		return arrayWithMaxValue;
	}

}
