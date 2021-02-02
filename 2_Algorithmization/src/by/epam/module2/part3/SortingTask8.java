package by.epam.module2.part3;

/*
 *Даны дроби p_1/q_1, p_2/q_2, ..., p_n/q_n (p_i, q_i - натуральные). Составить программу, которая приводит эти дроби к общему
знаменателю и упорядочивает их в порядке возрастания.
 */

public class SortingTask8 {

	public static void main(String[] args) {

		Fraction[] array = { new Fraction(2, 3), new Fraction(5, 9), new Fraction(1, 4) };

		arraySort(array);

		printArray(array);

	}

	public static void arraySort(Fraction[] array) {
		generalDenominatorSearch(array);

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j + 1].getNumerator() < array[j].getNumerator()) {
					swap(array, j + 1, j);
				}
			}
		}
	}

	public static void generalDenominatorSearch(Fraction[] array) {
		long generalDenominator = array[0].getDenominator();

		for (int i = 1; i < array.length; i++) {
			generalDenominator = lcm(array[i].getDenominator(), generalDenominator);
		}

		for (int i = 0; i < array.length; i++) {
			array[i].setNumerator (array[i].getNumerator() * generalDenominator / array[i].getDenominator());
			array[i].setDenominator(generalDenominator);
		}

	}

	public static long gcd(long a, long b) {
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

	public static long lcm(long a, long b) {
		// Алгоритм Евклида

		return a * b / gcd(a, b);

	}

	public static void swap(Fraction[] array, int index1, int index2) {
		Fraction temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void printArray(Fraction[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
