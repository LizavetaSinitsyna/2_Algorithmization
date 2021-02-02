package by.epam.module2.part3;

/*
 * Даны две последовательности a_1 <= a_2 <= ... <= a_n и b_1 <= b_2 <= ... <= b_m. Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
 */

public class SortingTask2 {

	public static void main(String[] args) {

		double[] array1 = { 1.7, 8, 10, 87.5, 96 };
		double[] array2 = { -9, 13, 14, 15.4, 45, 116 };

		printArray(mergeArrays(array1, array2));

	}

	public static double[] mergeArrays(double[] array1, double[] array2) {
		double[] result = new double[array1.length + array2.length];

		int firstArrayElementIndex = 0;
		int secondArrayElementIndex = 0;
		int resultElementIndex = 0;

		while (firstArrayElementIndex < array1.length && secondArrayElementIndex < array2.length) {
			if (array1[firstArrayElementIndex] <= array2[secondArrayElementIndex]) {
				result[resultElementIndex] = array1[firstArrayElementIndex];
				firstArrayElementIndex++;
			} else {
				result[resultElementIndex] = array2[secondArrayElementIndex];
				secondArrayElementIndex++;
			}
			resultElementIndex++;
		}

		for (int i = firstArrayElementIndex; i < array1.length; i++) {
			result[resultElementIndex] = array1[i];
			resultElementIndex++;
		}

		for (int i = secondArrayElementIndex; i < array2.length; i++) {
			result[resultElementIndex] = array2[i];
			resultElementIndex++;
		}

		return result;
	}

	public static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
