package by.epam.module2.part3;

/*
 * Сортировка Шелла с шагом.
 */

public class ShellSorting {

	public static void main(String[] args) {

		double[] array = { 0, -1, 7, 4, 2, 2, 1, -5, 3, 4, 10, 5 };

		shellSort(array);

		printArray(array);

	}

	public static void shellSort(double[] array) {

		int step = array.length / 2;

		while (step > 0) {
			for (int i = 0; i < array.length - step; i++) {
				int j = i;
				while (j >= 0 && array[j] > array[j + step]) {
					swap(array, j, j + step);
					j -= step;
				}
			}
			step /= 2;
		}

	}

	public static void swap(double[] array, int index1, int index2) {
		double temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
