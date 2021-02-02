package by.epam.module2.part3;

/*
 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
Делается это следующим образом: сравниваются два соседних элемента a_i и a_(i + 1). Если a_i <= a_(i + 1), то продвигаются
на один элемент вперед. Если a_i > a_(i + 1), то производится перестановка и сдвигаются на один элемент назад.
Составить алгоритм этой сортировки.
 */

public class SortingTask6 {

	public static void main(String[] args) {

		double[] array = { 0, -1, 7, 4, 2, 2, 1, -5, 3, 4, 10, 5 };

		shellSort(array);

		printArray(array);

	}

	public static void shellSort(double[] array) {

		int i = 0;

		while (i < array.length - 1) {
			if (array[i] > array[i + 1]) {
				swap(array, i, i + 1);
				if (i > 0) {
					i--;
				}
			} else {
				i++;
			}
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
