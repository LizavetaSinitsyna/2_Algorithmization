package by.epam.module2.part4;

/*Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.*/

public class DecompositionTask7 {

	public static void main(String[] args) {

		System.out.println(sum(1, 9));

	}

	public static int factorial(int number) {
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}

		return factorial;
	}

	public static boolean isOdd(int number) {
		return number % 2 == 0 ? false : true;
	}

	public static int sum(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (isOdd(i)) {
				sum += factorial(i);
			}
		}
		return sum;
	}

}
