package by.epam.module2.part3;

/*
 * Пусть даны две неубывающие последовательности действительных чисел a_1 <= a_2 <= ... <= a_n и b_1 <= b_2 <= ... <= b_m.
Требуется указать те места, на которые нужно вставлять элементы последовательности b_1 <= b_2 <= ... <= b_m в первую
последовательность так, чтобы новая последовательность оставалась возрастающей.
 */

public class SortingTask7 {

	public static void main(String[] args) {

		// double[] arrayA = {-1, 4, 8, 14, 14};
		// double[] arrayB = { 0, 4, 9, 14, 15, 16};

		double[] arrayA = { 0, 2, 4, 6, 8, 10 };

		double[] arrayB = { 1, 3, 5, 7, 9 };

		arrayMerge(arrayA, arrayB);

	}

	public static void arrayMerge(double[] array1, double[] array2) {

		int i = 0;
		int j = 0;

		int[] result = new int[array2.length];

		while (i < array1.length && j < array2.length) {
			if (array1[i] >= array2[j]) {
				result[j] = i + j;
				j++;
			} else {
				i++;
			}
		}

		while (j < array2.length) {
			result[j] = i + j;
			j++;
		}

		System.out.println(
				"Чтобы новая последовательность оставалась возрастающей, элементы второй последовательности нужно поставить в места первой последовательности со следующими индексами:");

		printArray(result);

	}

	public static void swap(double[] array, int index1, int index2) {
		double temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
