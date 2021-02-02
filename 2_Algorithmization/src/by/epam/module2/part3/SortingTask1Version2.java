package by.epam.module2.part3;

/*
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
дополнительный массив.
 */

public class SortingTask1Version2 {

	public static void main(String[] args) {

		double[] array1 = { 1.7, 8, -10, 87.5, 46 };
		double[] array2 = { 9, 3, 10, 15.4, 45, -16 };

		int k = 4;

		printArray(mergeArrays(array1, array2, k));

	}

	public static double[] mergeArrays(double[] array1, double[] array2, int k) {
		double[] result = new double[array1.length + array2.length];

		for (int i = 0; i < k; i++) {
			result[i] = array1[i];
		}

		for (int i = 0; i < array2.length; i++) {
			result[k + i] = array2[i];
		}

		for (int i = k; i < array1.length; i++) {
			result[k + array2.length] = array1[i];
		}

		return result;
	}

	public static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
