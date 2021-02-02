package by.epam.module2.part4;

import java.util.Scanner;

/*Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.*/

public class DecompositionTask3 {

	public static void main(String[] args) {

		double a = read("a >> ");

		System.out.println("Площадь правильного шестиугольника со стороной " + a + ": " + square(a));
	}

	public static double read(String message) {

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

	public static double square(double a) {

		return a * a * 3 * Math.sqrt(3) / 2;
	}

}
