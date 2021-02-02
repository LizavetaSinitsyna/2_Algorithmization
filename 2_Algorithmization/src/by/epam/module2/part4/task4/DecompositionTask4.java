package by.epam.module2.part4.task4;

import java.util.Scanner;

/*На плоскости заданы своими координатами n точек. Написать метод(методы), 
 *определяющие, между какими из пар точек самое большое расстояние. 
 *Указание. Координаты точек занести в массив.*/

public class DecompositionTask4 {

	public static void main(String[] args) {
		int n;
		Point[] array;
		PointPairsList result;
		double x;
		double y;

		PointPairsView show = new PointPairsView();

		n = readInt("Введите количество точек n больше 1 >> ");
		array = new Point[n];

		for (int i = 0; i < n; i++) {
			x = readDouble("x >> ");
			y = readDouble("y >> ");
			array[i] = new Point(x, y);
		}

		result = findMaxLengthBetweenPoints(array);

		show.printPointPairsList("Максимальное расстояние между двумя точками со следующими координатами: ", result);

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
		} while (number < 2);

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

	public static PointPairsList findMaxLengthBetweenPoints(Point[] array) {
		double max;
		double length;
		Point point1;
		Point point2;
		PointPair pair;
		PointPairsList list;
		int counter;

		max = 0;

		point1 = array[0];
		point2 = array[0];

		// Searching for max length by calculating the distance between all possible
		// pairs of dots

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				length = getLengthBetweenTwoPoints(array[j], array[i]);
				if (length > max) {
					max = length;
					point1 = array[i];
					point2 = array[j];
				}
			}

		}

		pair = new PointPair(point1, point2);
		list = new PointPairsList(new PointPair[] { pair });

		counter = 0;

		/*
		 * Checking an array for dots pairs' coordinates because it can be more than one
		 * pair of dots with max length.
		 */

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				length = getLengthBetweenTwoPoints(array[j], array[i]);
				if (length == max) {
					counter++;
					if (counter == 1) {
						continue; // As the first pair of dots with max destination between them is already saved
					} else {
						pair = new PointPair(array[i], array[j]);
						list.add(pair);

					}

				}
			}

		}

		return list;
	}

	public static double getLengthBetweenTwoPoints(Point point1, Point point2) {
		double length;

		length = Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));

		return length;
	}

}
