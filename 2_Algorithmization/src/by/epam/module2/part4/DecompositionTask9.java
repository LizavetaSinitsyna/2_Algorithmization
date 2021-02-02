package by.epam.module2.part4;

import java.util.Scanner;

/*Даны числа X, Y, Z, Т — длины сторон четырехугольника. 
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой.
*/

public class DecompositionTask9 {

	public static void main(String[] args) {

		double x = readDouble("Введите длину стороны х >> ");
		double y = readDouble("Введите длину стороны y >> ");
		double z = readDouble("Введите длину стороны z >> ");
		double t = readDouble("Введите длину стороны t >> ");

		square(x, y, z, t);

	}

	public static double readDouble(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		double number = 0;

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
		} else if (value <= 0) {
			System.out.println("The value must be bigger than 0.");
			return false;
		}
		return true;
	}

	public static boolean сheckExistanceOfQuadrangle(double x, double y, double z, double t) {

		if (x > y + z + t || y > x + z + t || z > x + y + t || t > x + y + z) {
			System.out.println("Четырехугольник с заданными сторонами не существует.");
			return false;
		}
		return true;
	}

	public static void square(double x, double y, double z, double t) {

		if (!сheckExistanceOfQuadrangle(x, y, z, t)) {
			return;
		}

		double diagonal;
		double firstTriangleSquare;
		double secondTriangleSquare;
		double semiperimeter;
		double result;

		diagonal = Math.sqrt(x * x + y * y);
		firstTriangleSquare = x * y / 2;

		semiperimeter = (z + t + diagonal) / 2;
		secondTriangleSquare = Math
				.sqrt(semiperimeter * (semiperimeter - z) * (semiperimeter - t) * (semiperimeter - diagonal));

		result = firstTriangleSquare + secondTriangleSquare;
		System.out.println("Площадь четырехугольника равна " + result);

	}
}
